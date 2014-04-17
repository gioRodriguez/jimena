$(document).ready(function() {
	var userName = $('#userNameTxt'); // getElementById
	userName.val('user name here');
	userName.focus(function() {
		if ($(this).val() == 'user name here') {
			$(this).val('');
		}
	});

	var userEmail = $('[name=userEmail]'); // $('.pass') getElementsByClass
	userEmail.val('user email here');

	var countriesPromise = $.get('/jimena-web-layer/json/countries');
	processPromise(countriesPromise, '#userCountryCmb ~ select');
	
	$('#userCountryCmb ~ select').change(function() {
		var citiesPromise = $.get(
				'/jimena-web-layer/json/cities', 
				{countryId: $('#userCountryCmb').val()}
		);		
		processPromise(citiesPromise, '#userCityCmb ~ select');
	});
	
	function processPromise(promise, selector){
		promise.done(function(response) {	
			fillUpCombWithSelector(
					response.countries, 
					selector
			);
		}).fail(function() {
			console.log('ocurrio un error :(');
		});
	}
	
	function fillUpCombWithSelector(items, selector){
		var options = items.map(function(country) {
			return '<option value="%id">%val</option>'
			.replace('%id', country.countryId)
			.replace('%val', country.countryName);
		});
		
		$(selector).html(options);
	}

});






