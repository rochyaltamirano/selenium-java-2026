Feature: Login

Scenario: Login válido

	Given El usuario se encuentra en la pantalla de Login
	When ingresa un usuario y contraseña válidos
	And hace clic en el botón de Login
	Then El usuario se encuentra logueado OK

Scenario: Login inválido
	
	Given El usuario se encuentra en la pantalla de Login
	When ingresa un usuario o contraseña inválidos
	And hace clic en el botón de Login
	Then El usuario no se encuentra logueado

Scenario: Empty fields
	
	Given El usuario se encuentra en la pantalla de Login
	When hace clic en el botón de Login
	Then se visualiza el pop up de Completa este campo