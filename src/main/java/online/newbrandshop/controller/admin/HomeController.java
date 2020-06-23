package online.newbrandshop.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import online.newbrandshop.modal.CategoryEntity;
import online.newbrandshop.modal.ImageEntity;
import online.newbrandshop.modal.ProductEntity;
import online.newbrandshop.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@RequestMapping("/admin")
@Controller("controllerForAdmin")
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
    CategoryRepository categoryRepository;
//    @RequestMapping("/uploadImage")
//    ModelAndView uploadImage()
//    {
//        ModelAndView mav=new ModelAndView("web/UploadImage");
//        return mav;
//    }
    
    //////test//////
    @RequestMapping("/AddNewProduct")
    ModelAndView AddNewProductPage()
    {
        ModelAndView mav=new ModelAndView("admin/new/AddNew");
        return mav;
    }
    @RequestMapping("/home")
    ModelAndView adminhome()
    {
        ModelAndView mav=new ModelAndView("admin/home");
        return mav;
    }
    
    @RequestMapping("/list")
    ModelAndView adminlist()
    {
        ModelAndView mav=new ModelAndView("admin/new/list");
        return mav;
    }
    
    @RequestMapping("/edit")
    ModelAndView adminedit()
    {
        ModelAndView mav=new ModelAndView("admin/new/edit");
        return mav;
    }
    @RequestMapping("/uploadImage")
    ModelAndView adminuploadimage()
    {
        ModelAndView mav=new ModelAndView("admin/imagepage/uploadimage");
        return mav;
    }
    ////-----//////

    @RequestMapping(value = "/AddNewProduct",method = RequestMethod.POST)
    public String AddNewProduct(@RequestParam("title")String title,@RequestParam("shortDescription")String shortDescription,
                                @RequestParam("price")String price,@RequestParam("images") List<CommonsMultipartFile> files,
                                @RequestParam("categoryCode")String categoryCode, HttpSession session) throws FileNotFoundException, JsonProcessingException {
        String path = session.getServletContext().getRealPath("/template/img");
        List<String>fileNameRe=new ArrayList<>();
        ProductEntity productEntity=new ProductEntity();
        productEntity.setName(new String (title.getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        List<CategoryEntity>categoryEntity=new ArrayList<>();
        categoryEntity.add(categoryRepository.findOneByCategoryName(categoryCode));
        productEntity.setListCategories(categoryEntity);
        productEntity.setActive(1);
        productEntity.setPrice(new String (price.getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        for (CommonsMultipartFile file:files){
            String filename = java.time.LocalDateTime.now().toString().replaceAll("\\.", ":").replaceAll(":", "-")+file.getOriginalFilename();

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
                fileNameRe.add("/template/img/"+filename);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/admin/list?addfail";
            }
        }
        JSONObject object=new JSONObject();
        object.put("img",fileNameRe);
        object.put("des",new String (shortDescription.getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        object.put("price",new String (price.getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        object.put("name",new String (title.getBytes (StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        productEntity.setContent(object.toString());
        productEntity.setUrl1(fileNameRe.get(0));
        productEntity.setAmount(100);
        productRepository.save(productEntity);
        return "redirect:/admin/list?addsuccess";
    }
//    @RequestMapping("/uploadedImage")
//    ModelAndView uploadedImage()
//    {
//        ModelAndView mav=new ModelAndView("/web/UploadedImage");
//        List<ImageEntity> imageEntities=imageRepository.findAll();
//        mav.addObject("test","huynh");
//        mav.addObject("list",imageEntities);
//        return mav;
//    }
}
