<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="808251237191-87qh11k1fpr56no376uduccp79iakop8.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
    <form name='form1' action='result.jsp' method='post'>
	    <input type='text' name='id' id='id' />
	    <input type='text' name='name' id='name' />   
	    <input type='text' name='url' id='url' />
	    <input type='text' name='email' id='email' /> 
	    <input type='submit' />
    </form>
  	
    <script>
   
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());
        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
        
        document.getElementById('id').value = profile.getId();
        document.getElementById('name').value = profile.getName();
        document.getElementById('url').value = profile.getImageUrl();
        document.getElementById('email').value = profile.getEmail();
        
      };
    </script>
  </body>
</html>