package com.sample.wishlistDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
@Service
public interface WishlistService {
    boolean saveProductToWishlist(String usrId,Wishlist wishlist);
    Wishlist saveAWishlist(Wishlist wishlist);
    Wishlist getWishlistByOwner(String owner);
    List<WishlistItem> getWishlistItemsByWishlistId(YaasAwareParameters yaasAware,String wishlistId);
    boolean saveWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId, WishlistItem wishlistItem);

}
