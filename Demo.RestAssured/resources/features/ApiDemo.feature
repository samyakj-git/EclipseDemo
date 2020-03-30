@ST_1
Feature: Validate place id

@JIRA_TC01

Scenario: Get Place Id against a phone number

Given "user" sets the base url of googleMap API
When "user" makes a get call to "googleMap" with below attributes
	|AttributeType | AttributeValue 						| pathparam|
	|input		   |+61293744000							| param    |
	|inputtype	   |phonenumber								| param	   |
	|key		   |AIzaSyDrl7Qyos5Klo1KFzaEpzJlU5ym8P8dYCI | param	   |

Then verify api recivess status code as 200
