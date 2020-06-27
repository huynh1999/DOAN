package online.newbrandshop.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import online.newbrandshop.modal.CategoryEntity;
import online.newbrandshop.modal.ImageEntity;
import online.newbrandshop.modal.ProductEntity;
import online.newbrandshop.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/api/")
public class AdminApi {
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
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    NameTypeRepository nameTypeRepository;

    @GetMapping("/getCategory")
    public String GetCategory()
    {
        List<CategoryEntity>categoryEntities=categoryRepository.findAll();
        StringBuilder rebody= new StringBuilder();
        for (CategoryEntity categoryEntity : categoryEntities) {
            rebody.append("|" + categoryEntity.getCategoryName());
        }
        return rebody.toString();
    }
    @GetMapping("/getCategory/{id}")
    public String GetCategoryProduct(@PathVariable("id")long id) throws JsonProcessingException {
        ProductEntity entity=productRepository.findById(id);
        List<CategoryEntity>categoryEntities=entity.getListCategories();
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(categoryEntities);
    }
    @PostMapping("/updateProduct")
    public String UpdateProduct(@RequestBody JsonNode node)
    {
        ProductEntity entity=productRepository.findById(node.get("id").asLong());
        List<CategoryEntity>categoryEntityList=new ArrayList<>();
        for (JsonNode node1:node.get("lsCate")
             ) {
           categoryEntityList.add(categoryRepository.findOneByCategoryName(node1.asText()));
        }
        entity.setListCategories(categoryEntityList);
        entity.setContent(node.get("content").asText());
        entity.setPrice(node.get("price").asText());
        entity.setName(node.get("name").asText());
        productRepository.save(entity);
        return "ok";
    }
}
