package com.sample.wishlistDemo.services;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.constants.Constants;
import com.sample.wishlistDemo.utils.JSONUtil;
import com.sample.wishlistDemo.utils.RestTemplateUtil;

@Repository
public class WishlistImpl implements IWishlist {
    
    @Override
    public boolean addProductToWishlist(String usrId,Wishlist wishlist) {
        
        RestTemplateUtil.post(Constants.BASE_URL, "");
        return false;
    }
    
    @Override
    public boolean saveWishlistToDoc(Wishlist wishlist) {
        RestTemplateUtil.post(Constants.BASE_URL+"/"+"wishlists/"+wishlist.getId(), JSONUtil.toJSONString(wishlist));
        return false;
    }

    @Override
    public Wishlist getWishlist() {
        // TODO Auto-generated method stub
        return null;
    }

}
