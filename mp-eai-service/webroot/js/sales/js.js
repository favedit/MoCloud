function Earnings(dir) {
	this.earnings = 0;
	this.calculate = function(picId, numId, cls) {
		var product = this.$(picId),
			inputs = product.getElementsByTagName("input"),
			earnings = Number(product.getAttribute('earnings')),
			min = parseInt(product.getAttribute('min')),
			t = parseInt(product.getAttribute('t')),
			period = parseInt(product.getAttribute('period')),
			total = parseInt(product.getAttribute('total')),
			that = this,
		    inputV0 = null,
		    inputV1 = null;
			earnings = earnings / 100;

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
					if (inputV1 < min) {
						inputs[1].value = "最少输入"+ t +"天";
						return false;
					}
					console.log(inputV0 +"--("+earnings +"----"+ total+")-----"+ inputV1);
					// this.earnings = inputV0 * ( earnings / total ) * inputV1;
					this.earnings = earnings / 365 * inputV1 * inputV0;
					inputs[2].value = this.earnings.toFixed(2);
				}else{
					// alert("请输入数字");
				}
			}
		// wrap=pic.parentNode;
		inputs[3].onclick = setCalculate;
		inputs[0].onfocus = function(){
			console.log(0)
			this.value = "";
		}
		inputs[1].onfocus =function(){
			console.log(1)
			this.value = "";
		}
		inputs[1].onkeyup = function(){
			var totals = parseInt(this.parentNode.parentNode.parentNode.parentNode.getAttribute('total'));
			if( this.value > totals){
				this.value = totals;
			}
		}

	}
	
}
Earnings.prototype.$ = function(id) {
	return typeof id === 'string' ? document.getElementById(id) : id;
}
window.onload = function() {
	var product = new Earnings();
	product.calculate('product');

	var product1 = new Earnings();
	product1.calculate('product1');

	var product2 = new Earnings();
	product2.calculate('product2');

	var product3 = new Earnings();
	product3.calculate('product3');

	var product4 = new Earnings();
	product4.calculate('product4');

	var product5 = new Earnings();
	product5.calculate('product5');

}