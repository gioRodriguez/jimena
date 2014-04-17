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
	countriesPromise.done(function(response) {
		fillUpCombWithSelector(
				response.countries, 
				'#userCountryCmb ~ select'
		);		
	}).fail(function() {
		console.log('ocurrio un error :(');
	});	
	
	$('#userCountryCmb ~ select').change(function() {
		var citiesPromise = $.get('/jimena-web-layer/json/cities', 
				{countryId: $('#userCountryCmb').val()});
		
		citiesPromise.done(function(response) {	
			fillUpCombWithSelector(
					response.countries, 
					'#userCityCmb ~ select'
			);
		});
	});
	
	function fillUpCombWithSelector(items, selector){
		var options = items.map(function(country) {
			return '<option value="%id">%val</option>'
			.replace('%id', country.countryId)
			.replace('%val', country.countryName);
		});
		
		$(selector).html(options);
	}

});






