package com.example.kakao.cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO{
        private List<ProductDTO> productDTOList;
        private int totalPrice;



        public FindAllByUserDTO(List<Cart> cartList) {
            // cartList.stream()
            //     .forEach( cart ->  += cart.getPrice() );
            this.totalPrice = cartList.stream().mapToInt( cart -> cart.getPrice() ).sum();

            List<Integer> pkCheck = new ArrayList<>();
            
            this.productDTOList = cartList.stream()
                .map( cart -> cart.getOption().getProduct() )
                .distinct()
                .map( product -> new ProductDTO(cartList, product) )
                
                // .map( cart -> new ProductDTO(cartList, cart.getOption().getProduct()) )
                // .filter( productDTO -> {
                //     System.out.println("테스트"+productDTO.hashCode());
                //     if( pkCheck.contains(productDTO.getId()) ){ return false; }
                //     else{ pkCheck.add(productDTO.getId()); return true; }
                // } )

                .collect( Collectors.toList() );


            productDTOList = productDTOList.stream()
                .filter( productDTO -> {
                    // System.out.println("테스트"+productDTO.hashCode());
                    if( pkCheck.contains(productDTO.getId()) ){ return false; }
                    else{ pkCheck.add(productDTO.getId()); return true; }
                } )
                .collect( Collectors.toList() );

        }



        @Getter @Setter @ToString
        class ProductDTO{
            private Integer id;
            private String name;
            private List<CartDTO> cartDTOList;
            
            public ProductDTO(List<Cart> cartList, Product product) {
                this.id = product.getId();
                this.name = product.getProductName();
                
                this.cartDTOList = cartList.stream()
                    .filter( cart -> cart.getOption().getProduct().equals(product) )
                    .map( cart -> new CartDTO(cart) )
                    .collect( Collectors.toList() );
            }
        }



        @Getter @Setter @ToString
        class CartDTO{
            private Integer cartId;
            private Integer cartQuantity;
            private Integer cartPrice;
            private OptionDTO optionDTO;

            public CartDTO(Cart cart) {
                this.cartId = cart.getId();
                this.cartQuantity = cart.getQuantity();
                this.cartPrice = cart.getPrice();
                this.optionDTO = new OptionDTO(cart.getOption());

            }
        }

        @Getter @Setter @ToString
        class OptionDTO{
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }
        }



    }
    












}
