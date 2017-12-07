
package com.sample.wishlistDemo.api.generated;

import java.net.URI;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;

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

	/* GET / */
	@Override
	public Response get(final YaasAwareParameters yaasAware)
	{
		String usrId = yaasAware.getHybrisUserId();
		Wishlist wishlist = wishlistService.getWishlistByUsrId(usrId);
		return Response.ok()
			.entity(wishlist).build();
	}

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final Wishlist wishlist)
	{
		String id=wishlistService.saveAWishlist(wishlist);
		URI uri = uriInfo.getRequestUriBuilder().path(id).build();
		return Response.created(uri).build();
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
		List<WishlistItem> wishlistItems = wishlistService.getWishlistItemsByWishlistId(yaasAware, wishlistId);
	    return Response.ok()
                .entity(wishlistItems).build();
	}
	
	@Override
	public
	Response getByWishlistIdWishlistcalculation(
			final YaasAwareParameters yaasAware,  final java.lang.String wishlistId)
	{
	    
	    return Response.noContent()
	            .build();
	    
	}

	@Override
	public
	Response postByWishlistIdWishlistItems(final YaasAwareParameters yaasAware,
			final java.lang.String wishlistId, final WishlistItem wishlistItem){
			wishlistService.saveWishlistItemsByWishlistId(yaasAware, wishlistId, wishlistItem);
	        return Response.created(uriInfo.getRequestUri()).build();
		
	}

}
