## Random Generex generator


  > localhost:8987/regexpress/{limitForEach}
  
  Sample:
  
  > localhost:8987/regexpress/15
  
  
  Body Sample:
  
  ````
  
  [
	"\\d{13}",
	"[!-~]{0,60}",
	"[0-9\\.]{7,16}",
	"((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-([0-1]?[0-9]|2[0-3]).([0-5][0-9]).([0-5][0-9]).\\d{6}",
	"[0-9a-zA-Z]{3,24}",
	"[0-9a-zA-Z]{0,24}",
	"[0-3]([a-c]|[e-g]{1,15})",
	"[0-3]([a-c]|[e-g]{1,30})",
	"[0-3]([a-c]|[e-g]{1,40})",
	"[0-3]([a-c]|[e-g]{1,5})",
	"[0-3]([a-c]|[e-g]{1,16})",
	"([01]?[0-9]|2[0-3]):[0-5][0-9]"
  ]

````