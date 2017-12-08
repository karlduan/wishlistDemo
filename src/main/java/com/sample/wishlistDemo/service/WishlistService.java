package com.sample.wishlistDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
@Service
public interface WishlistService {
    String saveAWishlist(Wishlist wishlist);
    Wishlist getWishlistByUsrId(String usrId);
    List<WishlistItem> getWishlistItemsByWishlistId(YaasAwareParameters yaasAware,String wishlistId);
    void saveWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId, WishlistItem wishlistItem);
}
