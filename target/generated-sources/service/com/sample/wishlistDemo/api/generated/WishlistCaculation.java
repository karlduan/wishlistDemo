package com.sample.wishlistDemo.api.generated;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
/**
 * Generated dto.
 */
@javax.annotation.Generated(value = "hybris", date = "Sun Dec 03 06:26:48 EST 2017")
@XmlRootElement
@JsonAutoDetect(isGetterVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE,
		creatorVisibility = Visibility.NONE, fieldVisibility = Visibility.NONE)
public class WishlistCaculation
{

	@com.fasterxml.jackson.annotation.JsonProperty(value="totalPrice")
	@javax.validation.constraints.NotNull
	private java.lang.String _totalPrice;

	public java.lang.String get_totalPrice() {
		return _totalPrice;
	}

	public void set_totalPrice(java.lang.String _totalPrice) {
		this._totalPrice = _totalPrice;
	}
	
}
