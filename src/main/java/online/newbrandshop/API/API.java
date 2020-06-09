package online.newbrandshop.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import online.newbrandshop.modal.ProductEntity;
import online.newbrandshop.modal.ProfileUserEntity;
import online.newbrandshop.modal.RoleUserEntity;
import online.newbrandshop.modal.UserEntity;
import online.newbrandshop.repository.*;
import online.newbrandshop.security.MyUser;
import online.newbrandshop.util.SecurityUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class API {
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
    @GetMapping(value = "/findAllNike" ,produces = "application/json;charset=UTF-8")
    String FindAllNike() throws JsonProcessingException {
        Pageable pageRequest= new PageRequest(0,1);
        List<ProductEntity>list=productRepository.find20Product();
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
    @GetMapping(value = "/content/{id}",produces = "application/json;charset=UTF-8")
    String ChiTiet(@PathVariable("id")Long id){
        return productRepository.findById(id).getContent();
    }

    @GetMapping(value = "/product/{id}",produces = "application/json;charset=UTF-8")
    String CheckOutInf(@PathVariable("id")Long id) throws JsonProcessingException {
        ProductEntity productEntity=productRepository.findById(id);
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(productEntity);
    }
    @PostMapping("user/changePass")
    String ChangePass(@RequestBody String body) throws IOException {
        try{
            ObjectMapper mapper=new ObjectMapper();
            UserEntity userEntity=null;
            try {
                userEntity=userRepository.findOneByUserNameAndActive(SecurityUtils.getPrincipal().getUsername(),1);
            }
            catch (Exception e){return "error";}
            JsonNode node=mapper.readTree(body);
            String oldPass=node.get("oldPass").asText();
            String newPass=node.get("newPass").asText();
            String renewPass=node.get("renewPass").asText();
            if(!newPass.equals(renewPass)){return "error";};
            if(BCrypt.checkpw(oldPass,userEntity.getPassword()))
            {
                userEntity.setPassword(BCrypt.hashpw(newPass,BCrypt.gensalt(10)));
                userRepository.save(userEntity);
                return "ok";
            }
        }
        catch (Exception e){return "error";};
        return "error";
    }
    @PostMapping(value = "/login-facebook")
    public String loginfb(HttpServletRequest request, @RequestBody String bd) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node=mapper.readTree(bd);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        UserEntity entity=userRepository.findOneByUserNameAndActive(node.get("id").asText(),1);
        if(entity!=null)
        {
            if(!(node.get("name").asText().equals(entity.getProfileUserEntity().getName())&&node.get("email").asText().equals(entity.getEmail())))
            {
                entity.getProfileUserEntity().setName(node.get("name").asText());
                entity.setEmail(node.get("email").asText());
                userRepository.save(entity);
            }
        }
        else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(node.get("id").asText());
            userEntity.setEmail(node.get("email").asText());
            userEntity.setActive(1);
            RoleUserEntity role = roleUserRepository.findOneById(2);
            userEntity.setRoleUserEntity(role);
            ProfileUserEntity profileUserEntity = new ProfileUserEntity();
            profileUserEntity.setName(node.get("name").asText());
            profileUserEntity.setPhonenumber("");
            profileUserEntity.setAddress("");
            userEntity.setProfileUserEntity(profileUserEntity);
            profileUserEntity.setUserEntity(userEntity);
            userRepository.save(userEntity);
            entity=userRepository.findOneByUserNameAndActive(node.get("id").asText(),1);
        }
        authorities.add(new SimpleGrantedAuthority("customer"));
        UserDetails userDetail = new MyUser(entity.getUserName(), "", enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        ((MyUser)userDetail).setName(entity.getProfileUserEntity().getName());
        ((MyUser)userDetail).setEmail(entity.getEmail());
        ((MyUser)userDetail).setAddress(entity.getProfileUserEntity().getAddress());
        ((MyUser)userDetail).setPhonenumber(entity.getProfileUserEntity().getPhonenumber());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("done");
        return "ok";
    }
    @PostMapping("/user/changeInfo")
    public  String ChangeInfo(@RequestBody String body, HttpServletRequest request, Authentication auth) throws IOException {
        try
        {
            ObjectMapper mapper=new ObjectMapper();
            JsonNode node=mapper.readTree(body);
            UserEntity entity=userRepository.findOneByUserNameAndActive(SecurityUtils.getPrincipal().getUsername(),1);
            entity.getProfileUserEntity().setName(node.get("name").asText());
            entity.getProfileUserEntity().setAddress(node.get("address").asText());
            entity.getProfileUserEntity().setPhonenumber(node.get("phone").asText());
            entity.setEmail(node.get("email").asText());
            userRepository.save(entity);
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            UserDetails userDetail = SecurityUtils.getPrincipal();
            ((MyUser)userDetail).setName(entity.getProfileUserEntity().getName());
            ((MyUser)userDetail).setEmail(entity.getEmail());
            ((MyUser)userDetail).setAddress(entity.getProfileUserEntity().getAddress());
            ((MyUser)userDetail).setPhonenumber(entity.getProfileUserEntity().getPhonenumber());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,auth.getCredentials(),
                    userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "ok";
        }
        catch (Exception e) {
            return "error";
        }
    }
}
