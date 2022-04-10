function redirect(url = "home") {
	const next = window.location.href + url
 	window.location.assign(next)

}