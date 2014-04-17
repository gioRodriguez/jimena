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

	$.get('/jimena-web-layer/json/countries')
	.done(function(response) {
		var options = response.countries.map(function(country) {
			return '<option value="%id">%val</option>'
			.replace('%id', country.countryId)
			.replace('%val', country.countryName);
		});
		
		$('#userCountryCmb ~ select').html(options);
		
	}).fail(function() {
		console.log('ocurrio un error :(');
	});

});






