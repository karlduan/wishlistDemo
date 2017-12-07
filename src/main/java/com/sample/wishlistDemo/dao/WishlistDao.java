package com.sample.wishlistDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;

@Repository
public interface WishlistDao {
    boolean saveProductToWishlist(String usrId,Wishlist wishlist);
    Wishlist saveAWishlist(Wishlist wishlist);
    Wishlist getWishlistByOwner(String owner);
    List<WishlistItem> getWishlistItemsByWishlistId(YaasAwareParameters yaasAware,String wishlistId);
    boolean saveWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId, WishlistItem wishlistItem);
}
