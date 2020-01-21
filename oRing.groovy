import eu.mihosoft.vrl.v3d.parametrics.*;
CSG generate(){
	String type= "oRing"
	if(args==null)
		args=["2inchOD"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def ODValue = measurments.OD
	def priceValue = measurments.price
	def massCentroidYValue = measurments.massCentroidY
	def widthValue = measurments.width
	def massCentroidXValue = measurments.massCentroidX
	def sourceValue = measurments.source
	def massCentroidZValue = measurments.massCentroidZ
	def IDValue = measurments.ID
	def massKgValue = measurments.massKg
	println "Measurment ODValue =  "+ODValue
	println "Measurment priceValue =  "+priceValue
	println "Measurment massCentroidYValue =  "+massCentroidYValue
	println "Measurment widthValue =  "+widthValue
	println "Measurment massCentroidXValue =  "+massCentroidXValue
	println "Measurment sourceValue =  "+sourceValue
	println "Measurment massCentroidZValue =  "+massCentroidZValue
	println "Measurment IDValue =  "+IDValue
	println "Measurment massKgValue =  "+massKgValue
	// Stub of a CAD object
	CSG part = new Cube().toCSG()
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 