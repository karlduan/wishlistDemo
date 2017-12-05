
package com.sample.wishlistDemo.api.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.wishlistDemo.service.WishlistService;

/**
* Resource class containing the custom logic. Please put your logic here!
*/
@Component("apiWishlistsResource")
@Singleton
public class DefaultWishlistsResource implements com.sample.wishlistDemo.api.generated.WishlistsResource
{
	@javax.ws.rs.core.Context
	private javax.ws.rs.core.UriInfo uriInfo;
	@Autowired
	WishlistService wishlistService;
	
	private Map<String, Wishlist> wishMap = new HashMap<String, Wishlist>();
	private final static String DUMMY_KEY="C6724366777";

	/* GET / */
	@Override
	public Response get(final YaasAwareParameters yaasAware)
	{
		String usrId = yaasAware.getHybrisUserId();
		System.out.println(wishMap);
		// place some logic here
		return Response.ok()
			.entity(wishMap.get(DUMMY_KEY)).build();
	}

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final Wishlist wishlist)
	{
		String usrId = yaasAware.getHybrisUserId();
		System.out.println(wishMap);
		wishMap.put(DUMMY_KEY, wishlist);
//      iWishlist.saveWishlistToDoc(wishlist);
		wishlistService.saveAWishlist(wishlist);
		return Response.ok()
	            .entity(wishlist).build();
	}

	/* GET /{wishlistId} */
	@Override
	public Response getByWishlistId(final YaasAwareParameters yaasAware, final java.lang.String wishlistId)
	{
		return Response.ok()
			.entity(new Wishlist()).build();
	}

	/* PUT /{wishlistId} */
	@Override
	public Response putByWishlistId(final YaasAwareParameters yaasAware, final java.lang.String wishlistId, final Wishlist wishlist)
	{
		return Response.ok()
			.build();
	}

	/* DELETE /{wishlistId} */
	@Override
	public Response deleteByWishlistId(final YaasAwareParameters yaasAware, final java.lang.String wishlistId)
	{
		return Response.noContent()
			.build();
	}

	@Override
	public
	Response getByWishlistIdWishlistItems(
			final YaasAwareParameters yaasAware,  final java.lang.String wishlistId)
	{
	    
	   /*Wishlist wishlist = wishMap.get(DUMMY_KEY);
	    if (StringUtils.equals(wishlistId, wishlist.getId())) {
            return Response.ok()
                    .entity(wishlist.getItems()).build();
        }
	    else {
	        return Response.ok()
	                .entity(new java.util.ArrayList<WishlistItem>()).build();
        }*/
	    List<WishlistItem> WishlistItems = wishlistService.getWishlistItemsByWishlistId(yaasAware, wishlistId);
	    return Response.ok()
                .entity(WishlistItems==null?new ArrayList<WishlistItem>():WishlistItems).build();
	    
	}
	
	@Override
	public
	Response getTotalPriceByWistlistId(
			final YaasAwareParameters yaasAware,  final java.lang.String wishlistId)
	{
	    
	    List<WishlistItem> WishlistItems = wishlistService.getWishlistItemsByWishlistId(yaasAware, wishlistId);
	    return Response.ok()
                .entity(WishlistItems==null?new ArrayList<WishlistItem>():WishlistItems).build();
	    
	}

	@Override
	public
	Response postByWishlistIdWishlistItems(final YaasAwareParameters yaasAware,
			final java.lang.String wishlistId, final WishlistItem wishlistItem){
		// place some logic here
	    /*Wishlist wishlist = wishMap.get(DUMMY_KEY);
	    if (StringUtils.equals(wishlistId, wishlist.getId())) {
	        if (wishlist.getItems()==null) {
	            List<WishlistItem> wishlistItemList=new ArrayList<WishlistItem>();
	            wishlistItemList.add(wishlistItem);
	            wishlist.setItems(wishlistItemList);
            }
	        else {
	            wishlist.getItems().add(wishlistItem);
            }
	        wishMap.put(DUMMY_KEY, wishlist);
	        return Response.ok()
	                .build();
        }
	    else {
	        return Response.noContent()
                    .build();
        }*/
	    wishlistService.saveWishlistItemsByWishlistId(yaasAware, wishlistId, wishlistItem);
	    return Response.ok()
                .build();
		
	}

}
