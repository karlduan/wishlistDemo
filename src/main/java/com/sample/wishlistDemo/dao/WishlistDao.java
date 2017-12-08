package com.sample.wishlistDemo.dao;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;

@Repository
public interface WishlistDao {
    String saveAWishlist(Wishlist wishlist);
    String getWishlists();
    String getByWishlistId(YaasAwareParameters yaasAware,String wishlistId);
}
