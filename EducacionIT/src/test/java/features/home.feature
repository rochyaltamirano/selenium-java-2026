Feature: Home

Scenario: Ingresar a la pantalla de Login

	Given El usuario se encuentra en la pantalla Home
	When Hace clic en Login
	Then Se redirige a la pantalla de Login
	
	
Scenario: Ingresar a la pantalla de Products

	Given El usuario se encuentra en la pantalla Home
	When Hace clic en Products
	Then Se redirige a la pantalla de Products
	

Scenario: Ingresar a la pantalla de Carts

	Given El usuario se encuentra en la pantalla Home
	When Hace clic en Carts
	Then Se redirige a la pantalla de Carts
	