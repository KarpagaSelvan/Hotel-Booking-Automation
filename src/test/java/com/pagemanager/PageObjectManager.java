package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Used to create Object for all pages
 */
public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;

	/**
	 * 
	 * @see Used to check whether the Object is created for Login page if not
	 * @return loginpage
	 * 
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	/**
	 * 
	 * @see Used to check whether the Object is created for SearchHotelPage if not
	 * @return searchHotelPage
	 * 
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}

	/**
	 * @see Used to check whether the Object is created for SelectHotelPage if not
	 * @return SelectHotelPage
	 * 
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	/**
	 * 
	 * @see Used to check whether the Object is created for BookHotelPage if not
	 * @return BookHotelPage
	 * 
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	/**
	 * 
	 * @see Used to check whether the Object is created for BookingConfirmationPage if not
	 * @return bookingConfirmationPage
	 * 
	 */
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage == null) ? bookingConfirmationPage = new BookingConfirmationPage()
				: bookingConfirmationPage;
	}

	/**
	 * 
	 * @see Used to check whether the Object is created for CancelBookingPage if not
	 * @return cancelBookingPage
	 * 
	 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null) ? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}

}
