package online.newbrandshop.controller.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import online.newbrandshop.modal.*;
import online.newbrandshop.repository.*;
import online.newbrandshop.security.MyUser;
import online.newbrandshop.util.SecurityUtils;
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
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	   public ModelAndView homePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/home");
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
	//test fe profile
	@RequestMapping("/profile")
	ModelAndView profile(){
		ModelAndView mav=new ModelAndView("web/profile");
		return mav;
	}
	//test fe chi tiet lic su mua hang
		@RequestMapping("/chitietlichsu")
		ModelAndView chitietls(){
			ModelAndView mav=new ModelAndView("web/chitietlichsu");
			return mav;
		}
	@RequestMapping("/checkout")
	ModelAndView checkout(){
		ModelAndView mav=new ModelAndView("web/checkout");
		return mav;
	}
	//test fe admin
	@RequestMapping("/admintest")
	ModelAndView admin(){
		ModelAndView mav=new ModelAndView("admin/new/list");
		return mav;
	}
	@RequestMapping("/uploadImage")
	ModelAndView uploadImage()
	{
		ModelAndView mav=new ModelAndView("web/UploadImage");
		return mav;
	}
	@RequestMapping(value = "/savefile",method = RequestMethod.POST)
	public String savefile(@RequestParam CommonsMultipartFile file, HttpSession session) throws FileNotFoundException {
		String path = session.getServletContext().getRealPath("/template/img");
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();
			ImageEntity imageEntity=new ImageEntity();
			imageEntity.setLink("/template/img/"+filename);
			imageRepository.save(imageEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "web/UploadImage";
	}
	@RequestMapping("/uploadedImage")
	ModelAndView uploadedImage()
	{
		ModelAndView mav=new ModelAndView("/web/UploadedImage");
		List<ImageEntity>imageEntities=imageRepository.findAll();
		mav.addObject("test","huynh");
		mav.addObject("list",imageEntities);
		return mav;
	}
	@RequestMapping(value = "/login-facebook",method = RequestMethod.POST)
	public String test(HttpServletRequest request, @RequestBody String bd) throws IOException {
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(bd);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("customer"));
		UserDetails userDetail = new MyUser(node.get("id").asText(), "123", enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		((MyUser)userDetail).setName(node.get("name").asText());
		((MyUser)userDetail).setEmail(node.get("email").asText());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("done");
		return "redirect:/home";
	}
}
