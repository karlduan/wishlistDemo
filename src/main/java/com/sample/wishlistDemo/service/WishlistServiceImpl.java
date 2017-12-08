package com.sample.wishlistDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.wishlistDemo.api.generated.Wishlist;
import com.sample.wishlistDemo.api.generated.WishlistItem;
import com.sample.wishlistDemo.api.generated.YaasAwareParameters;
import com.sample.wishlistDemo.dao.WishlistDao;
import com.sample.wishlistDemo.utils.JSONUtil;
@Service
public class WishlistServiceImpl implements WishlistService {
    
    @Autowired
    WishlistDao wishlistDao;

    @Override
    public String saveAWishlist(Wishlist wishlist) {
    	String ret = wishlistDao.saveAWishlist(wishlist);
        return StringUtils.contains(ret, "id")?wishlist.getId():StringUtils.EMPTY;
        
    }

    @Override
    public Wishlist getWishlistByUsrId(String usrId) {
    	Wishlist wishlistRet = new Wishlist();
    	List<Wishlist> wishlists = JSONUtil.parseArray(wishlistDao.getWishlists(), Wishlist.class);
    	for (Wishlist wishlist : wishlists) {
			if (StringUtils.equalsAnyIgnoreCase(wishlist.getOwner(), usrId)) {
				wishlistRet= wishlist;
				break;
			}
		}      
        return wishlistRet;
    }

    @Override
    public List<WishlistItem> getWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId) {
    	Wishlist wishlist = JSONUtil.parseObject(wishlistDao.
    			getByWishlistId(yaasAware, wishlistId),Wishlist.class);
        return wishlist.getItems();
    }

    @Override
    public void saveWishlistItemsByWishlistId(YaasAwareParameters yaasAware, String wishlistId,
            WishlistItem wishlistItem) {
    	Wishlist wishlist = JSONUtil.parseObject(wishlistDao.getByWishlistId(yaasAware, wishlistId), Wishlist.class);
    	List<WishlistItem> wishlistItems = wishlist.getItems();
		if (wishlistItems != null) {
			wishlistItems.add(wishlistItem);
		} else {
			wishlistItems = new ArrayList<WishlistItem>();
			wishlistItems.add(wishlistItem);
		}
		wishlist.setItems(wishlistItems);
    }

}
