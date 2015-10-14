function Earnings(dir) {
	this.earnings = 0;
	that = this,
	// this.deom = this.$(dir);
	this.setClick = function(picId, fun){
		var product = this.$(picId);
		var lists = product.getElementsByTagName("div");
		var listsL= lists.length;
			for (var i = 0; i < listsL; i++ ){
				if(lists[i].className == "product" ){
					lists[i].onclick = function(){
						if(this.getAttribute("data") === "on"){
							this.setAttribute("data","");
						}else{
							for(var j=0; j < listsL; j++ ){
								lists[j].setAttribute("data","");
							}
							this.setAttribute("data","on");
						}
					}
				}
			}
	};
	this.calculate = function(picId, picId2,numId, cls) {
		var product = this.$(picId),
			inputs = product.getElementsByTagName("input"),
			moneys = document.getElementsByClassName("money"),
			btn = product.getElementsByClassName("btn"),
			percentage = this.$(picId2),
			percentages = percentage.getElementsByTagName("input"),
			percentageLe = percentages.length,
			bank = document.getElementsByClassName("bank"),
			earnings= 0;
		    inputV0 = null;
		    inputV1 = null;
			function setCalculate() {
				inputV0 = inputs[0].value;
				inputV1 = inputs[1].value;
				if(!isNaN(inputV0) && !isNaN(inputV1)){
					if( inputV0 == "" ){
						inputs[0].value = "请输入投资金额";
						return false;
					}else if( inputV1 == "" ){
						inputs[1].value = "请输入投资天数";
						return false;
					}
					if (inputV1 < 2) {
						inputs[1].value = "最少输入"+ 2 +"天";
						return false;
					}
					for(var i = 0; i< percentageLe; i++ ){
						// console.log(percentages[i].getAttribute("earnings") / 100+"..."+inputV1+inputV0);
						bank[0].style.display = "block";
						this.earnings = (percentages[i].getAttribute("earnings") / 100 ) / 365 * inputV1 * inputV0;
						moneys[i].innerHTML = this.earnings.toFixed(2);
					}
				}
			}
		btn[0].onclick = setCalculate;
		inputs[0].onfocus = function(){
			this.value = "";
		}
		inputs[1].onfocus =function(){
			this.value = "";
		}
		inputs[1].onkeyup = function(){
			if( this.value > 365){
				this.value = 365;
			}
		}
	}
}
Earnings.prototype.$ = function(id) {
	return typeof id === 'string' ? document.getElementById(id) : id;
}
window.onload = function() {
	var product = new Earnings();
	product.setClick('product');
	product.calculate('calculate-container',"percentage");
}