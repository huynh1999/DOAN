package online.newbrandshop.controller.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import online.newbrandshop.modal.*;
import online.newbrandshop.repository.*;
import online.newbrandshop.security.MyUser;
import online.newbrandshop.util.SecurityUtils;
import online.newbrandshop.util.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProfileUserRepository profileUserRepository;
	@Autowired
	RoleUserRepository roleUserRepository;
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	BillRepository billRepository;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	   public ModelAndView homePage(HttpSession session) {
//		if(SecurityUtils.isAuthenticanted())
//		{
//			System.out.println(SecurityUtils.getPrincipal().getUsername());
//		}
//		else {System.out.println("Not Login");}
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@RequestParam("username")String userName,@RequestParam("fullname")String fullName
								,@RequestParam("phone") String phone,@RequestParam("email")String email
								,@RequestParam("password")String password,@RequestParam("address")String address)
	{
		try {
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(userName);
			userEntity.setEmail(email);
			userEntity.setActive(1);
			userEntity.setPassword(BCrypt.hashpw(password,BCrypt.gensalt(10)));
			RoleUserEntity role = roleUserRepository.findOneById(2);
			userEntity.setRoleUserEntity(role);
			ProfileUserEntity profileUserEntity = new ProfileUserEntity();
			profileUserEntity.setAddress(address);
			profileUserEntity.setName(fullName);
			profileUserEntity.setPhonenumber(phone);
			userEntity.setProfileUserEntity(profileUserEntity);
			profileUserEntity.setUserEntity(userEntity);
			userRepository.save(userEntity);
		}
		catch (Exception e)
		{
			return "redirect:home?errorRegister";
		}
		return "redirect:home?successRegister";
	}
	@RequestMapping("/category")
	ModelAndView category(){
		ModelAndView mav=new ModelAndView("web/category");
		return mav;
	}

	@RequestMapping("/product/{idproduct}")
	ModelAndView chitiet(@PathVariable("idproduct")Long id){
		ModelAndView mav=new ModelAndView("web/chitietsp");
		ProductEntity productEntity=productRepository.findById(id);
		mav.addObject("item",productEntity);
		return mav;
	}

	@RequestMapping("/custom")
	ModelAndView custom(){
		ModelAndView mav=new ModelAndView("web/custom");
		return mav;
	}

	@RequestMapping("/cart")
	ModelAndView cart(){
		ModelAndView mav=new ModelAndView("web/checkout");
		return mav;
	}
	//test fe admin
	@RequestMapping("/admintest")
	ModelAndView admin(){
		ModelAndView mav=new ModelAndView("admin/new/list");
		return mav;
	}
	@RequestMapping("bill/{nameBill}")
	public ModelAndView GetBill(@PathVariable("nameBill") String nameBill) throws IOException {
		BillEntity billEntity=billRepository.findByBillName(nameBill);
		ModelAndView modelAndView=new ModelAndView("/web/chitietlichsu");
		if(billEntity.getCreatedBy().equals("anonymousUser"))
		{
			modelAndView.addObject("data",billEntity.getContent());
			modelAndView.addObject("total",new String(billEntity.getTotalMoney()));
		}
		else{
			if(SecurityUtils.isAuthenticanted())
			{
				if(SecurityUtils.getPrincipal().getUsername().equals(billEntity.getCreatedBy())){
					modelAndView.addObject("data",billEntity.getContent());
					modelAndView.addObject("total",new String(billEntity.getTotalMoney()));
				}
				else{
					modelAndView.addObject("data","error");
				}
			}else modelAndView.addObject("data","error");
		}

		return modelAndView;
	}
	@RequestMapping(value = "/checkout",method = RequestMethod.POST)
	String checkout(@RequestParam("content")String content,@RequestParam("name")String name
						 ,@RequestParam("address")String address,@RequestParam("phone")String phone
						 ,@RequestParam("email")String email) throws IOException {
		try {
			String nameBill=Utils.GetNameBill();
			ObjectMapper mapper=new ObjectMapper();
			BillEntity billEntity=new BillEntity();
			billEntity.setBillName(nameBill);
			billEntity.setStatus(0);
			BigInteger totalMoney=new BigInteger("0");
			JsonNode nodes=mapper.readTree(content);
			JSONArray jsonArray=new JSONArray();
			for(JsonNode single:nodes)
			{
				ProductEntity productEntity=productRepository.findById((long) single.get("id").asInt());
				JSONObject json = new JSONObject();
				json.put("id",productEntity.getId());
				json.put("price",(new BigInteger(productEntity.getPrice().replaceAll("\\D+","")).multiply(new BigInteger(single.get("amount").asText()))).toString());
				json.put("img",productEntity.getUrl1());
				json.put("amount",single.get("amount").asInt());
				json.put("name",productEntity.getName());
				jsonArray.put(json);
				totalMoney=totalMoney.add(new BigInteger(productEntity.getPrice().replaceAll("\\D+","")).multiply(new BigInteger(single.get("amount").asText())));
			}
			billEntity.setContent(jsonArray.toString());
			billEntity.setTotalMoney(totalMoney.toString());
			billEntity.setPaymentMethod("COD");
			PayerEntity payerEntity=new PayerEntity();
			payerEntity.setName(name);
			payerEntity.setEmail(email);
			payerEntity.setAddress(address);
			payerEntity.setPhone(phone);
			billEntity.setPayerEntity(payerEntity);
			payerEntity.setBillEntity(billEntity);
			billRepository.save(billEntity);
			return "redirect:/bill/"+nameBill;
		}
		catch (Exception e){
			return "redirect:/cart?error";
		}
	}

}
