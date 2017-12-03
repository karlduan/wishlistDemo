package com.sample.wishlistDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
import com.sample.wishlistDemo.dao.WishlistDao;
@Service
public class WishlistServiceImpl implements WishlistService {
    
    @Autowired
    WishlistDao wishlistDao;

    @Override
    public boolean saveProductToWishlist(String usrId, Wishlist wishlist) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean saveAWishlist(Wishlist wishlist) {
        wishlistDao.saveAWishlist(wishlist);
        return false;
    }

    @Override
    public Wishlist getWishlist() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Wishlist getWishlistByOwner(String owner) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<WishlistItem> getWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean saveWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId,
            WishlistItem wishlistItem) {
        // TODO Auto-generated method stub
        return false;
    }

}
