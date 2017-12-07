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
        
        RestTemplateUtil.post("", "");
        return false;
    }
    
    @Override
    public Wishlist saveAWishlist(Wishlist wishlist) {
        RestTemplateUtil.post("/wishilist"+"/"+wishlist.getOwner(), JSONUtil.toJSONString(wishlist));
        return null;
    }


    @Override
    public Wishlist getWishlistByOwner(String owner) {
        Wishlist wishlist = JSONUtil.parseObject(RestTemplateUtil.get("/wishlist"+"/"+owner), Wishlist.class);
        return wishlist;
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
