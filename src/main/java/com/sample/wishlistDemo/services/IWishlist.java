package com.sample.wishlistDemo.services;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;

@Repository
public interface IWishlist {
    boolean addProductToWishlist(String usrId,Wishlist wishlist);
    boolean saveWishlistToDoc(Wishlist wishlist);
    Wishlist getWishlist();
}
