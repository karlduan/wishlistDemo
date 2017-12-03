package com.sample.wishlistDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
import com.sample.wishlistDemo.constants.Constants;
import com.sample.wishlistDemo.utils.JSONUtil;
import com.sample.wishlistDemo.utils.RestTemplateUtil;

@Repository
public class WishlistDaoImpl implements WishlistDao {
    
    @Override
    public boolean saveProductToWishlist(String usrId,Wishlist wishlist) {
        
        RestTemplateUtil.post(Constants.BASE_URL, "");
        return false;
    }
    
    @Override
    public boolean saveAWishlist(Wishlist wishlist) {
        RestTemplateUtil.post(Constants.BASE_URL+"/"+"wishlists/"+wishlist.getId(), JSONUtil.toJSONString(wishlist));
        return false;
    }

    @Override
    public Wishlist getWishlist() {
//        RestTemplateUtil
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
