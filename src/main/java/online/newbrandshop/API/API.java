package online.newbrandshop.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import online.newbrandshop.modal.ProductEntity;
import online.newbrandshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class API {
    @Autowired
    ProductRepository productRepository;
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
}
