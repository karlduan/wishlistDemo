package com.sample.wishlistDemo.dao;

import org.springframework.stereotype.Repository;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
import com.sample.wishlistDemo.utils.JSONUtil;
import com.sample.wishlistDemo.utils.RestTemplateUtil;

@Repository
public class WishlistDaoImpl implements WishlistDao {
    
    @Override
    public String saveAWishlist(Wishlist wishlist) {
        return RestTemplateUtil.post("/"+wishlist.getId(), JSONUtil.toJSONString(wishlist));
    }

    @Override
    public String getWishlists() {
        return RestTemplateUtil.get("/");
    }

    @Override
    public String getByWishlistId(YaasAwareParameters yaasAware, String wishlistId) {
        return RestTemplateUtil.get("/"+wishlistId);
    }

}
