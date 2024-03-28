package com.myintellij.dto;

import com.myintellij.constant.ItemSellStatus;
import com.myintellij.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ItemFormDto {
    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값")
    private String itemNm;
    @NotNull(message = "가격은 필수 입력 값")
    private Integer price;
    @NotBlank(message = "이름은 필수 입력 값")
    private String itemDetail;
    @NotNull(message = "재고는 필수 입력 값")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); // 상품 저장 후 수정 시 상품 이미지 정보를 저장하는 리스트
    private List<Long> itemImgIds = new ArrayList<>(); // 상품 이미지 아이디를 저장하는 리스트(수정 시)
    private static ModelMapper modelMapper = new ModelMapper();

    public Item creatItem() {
        return modelMapper.map(this, Item.class);
    } // 엔티티 객체와 DTO 객체 간의 데이터를 복사해 복사한 객체를 반환하는 메소드
    public static ItemFormDto of(Item item) {
        return modelMapper.map(item, ItemFormDto.class);
    }

}
