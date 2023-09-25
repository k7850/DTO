package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.product.option.Option;
import com.example.kakao.product.option.OptionJPARepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;
    private final OptionJPARepository optionJPARepository;

    // (기능2) 상품 상세보기
    public ProductResponse.FindByIdDTO findById(int id) {
        return null;
    }

    // 상품조회 + 옵션조회
    public ProductResponse.FindByIdV1DTO findByIdV1(int id) {
        Product productPS = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 상품을 찾을 수 없습니다 : " + id));

        List<Option> optionsPS = optionJPARepository.findByProductId(id);

        return new ProductResponse.FindByIdV1DTO(productPS, optionsPS);
    }

    // 양방향 조회
    public ProductResponse.FindByIdV2DTO findByIdV2(int id) {
        Product productPS = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 상품을 찾을 수 없습니다 : " + id));
        System.out.println("아직 option을 Lazy Loading 하기 전입니다 =============");
        return new ProductResponse.FindByIdV2DTO(productPS);
    }

    // 옵션만 조회
    public ProductResponse.FindByIdV3DTO findByIdV3(int id) {
        List<Option> optionsPS = optionJPARepository.findByProductId(id);
        return new ProductResponse.FindByIdV3DTO(optionsPS);
    }

    // 엔티티 응답
    public List<Option> findByIdV4(int id) {
        List<Option> optionsPS = optionJPARepository.findByProductId(id);
        return optionsPS;
    }

    

    // public List<ProductResponse.FindAllDTO> findAll(int page) {
    //     Pageable pageable = PageRequest.of(page,9);
    //     Page<Product> pageContent = productRepository.findAll(pageable);
    //     List<ProductResponse.FindAllDTO> responseDTOs = pageContent.getContent().stream().map(ProductResponse.FindAllDTO::new).collect(Collectors.toList());
    //     return responseDTOs;
    // }


    public List<ProductResponse.ProductDTO> 상품목록보기(int page) {

        // List<Product> productList = productJPARepository.findAll();

        // List<ProductResponse.ProductDTO> productDTOList = productList.stream()
        //         .map( product -> new ProductResponse.ProductDTO(product) )
        //         .collect( Collectors.toList() );
        
        // return productDTOList;


        
        Pageable pageable = PageRequest.of(page,5); // PageRequest.of(현재페이지, 한페이지당개수)
        Page<Product> pageContent = productJPARepository.findAll(pageable);

        List<Product> productList = pageContent.getContent(); // getContent로 List
        
        List<ProductResponse.ProductDTO> productDTOList = productList.stream()
                .map( product -> new ProductResponse.ProductDTO(product) )
                .collect(Collectors.toList());

        return productDTOList;

    }









    
}
