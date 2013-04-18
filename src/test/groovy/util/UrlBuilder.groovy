package util

class UrlBuilder {

	static buildUrl(segment) {
		baseUrl() + segment + language()
	}

	static baseUrl() {
		"https://www.unience.com"
	}

	static language() {
		"?lang=en"
	}
}