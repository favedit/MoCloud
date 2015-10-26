function Earnings(dir) {
    this.earnings = 0;
    that = this;
    // this.deom = this.$(dir);
    this.setClick = function(picId, fun) {
        var product = this.$(picId);
        var lists = product.getElementsByTagName("div");
        var listsL = lists.length;
        for (var i = 0; i < listsL; i++) {
            if (lists[i].className == "product") {
                lists[i].onclick = function() {
                    if (this.getAttribute("data") === "on") {
                        this.setAttribute("data", "");
                    } else {
                        for (var j = 0; j < listsL; j++) {
                            lists[j].setAttribute("data", "");
                        }
                        this.setAttribute("data", "on");
                    }
                }
            }
        }
    };
    this.calculate = function(picId, picId2, numId, cls) {
        var product = this.$(picId), inputs = product
                .getElementsByTagName("input"), mostDay = document
                .getElementsByTagName("i"), moneys = document
                .getElementsByClassName("money"), products = document
                .getElementsByClassName("product"), btn = product
                .getElementsByClassName("btn"), percentage = this.$(picId2), percentages = percentage
                .getElementsByTagName("input"), percentageLe = percentages.length, bank = document
                .getElementsByClassName("bank"), earnings = 0;
        inputV0 = null;
        inputV1 = null;
        function setCalculate() {
            inputV0 = inputs[0].value;
            inputV1 = inputs[1].value;
            if (!isNaN(inputV0) && !isNaN(inputV1)) {
                if (inputV0 == "") {
                    inputs[0].value = "请输入投资金额";
                    return false;
                } else if (inputV0 < 0) {
                    inputs[0].value = "请输入投资金额";
                    return false;
                } else if (inputV1 == "") {
                    inputs[1].value = "请输入投资天数";
                    return false;
                }
                if (inputV1 < 2) {
                    inputs[1].value = "最少输入" + 2 + "天";
                    return false;
                }
                var day = 0, tm = null;
                bank[0].style.display = "block";
                for (var i = 0; i < percentageLe; i++) {
                    if (i < percentageLe - 1) {
                        products[i].setAttribute("data", " ");
                    }
                    day = percentages[i].getAttribute("total");
                    mostDay[i].style.display = "none";
                    if (Number(inputs[1].value) < percentages[i]
                            .getAttribute("min")) {
                        moneys[i].innerHTML = 0;
                        mostDay[i].style.display = "inline-block";
                    } else {
                        if (Number(inputs[1].value) <= day) {
                            moneys[i].innerHTML = ((percentages[i]
                                    .getAttribute("earnings") / 100)
                                    / 365 * inputV1 * inputV0).toFixed(2);
                        } else {
                            moneys[i].innerHTML = 0;
                            mostDay[i].style.display = "inline-block";
                        }
                    }

                }
            }
        }
        btn[0].onclick = setCalculate;
        inputs[0].onfocus = function() {
            this.value = "";
        }
        inputs[0].onkeyup = function() {
            if (!Number(this.value) || this.value < 0) {
                this.value = "";
            }
        }
        inputs[1].onfocus = function() {
            this.value = "";
        }
        inputs[1].onkeyup = function() {
            var re = /^[1-9]+[0-9]*]*$/;
            if (!Number(this.value) || this.value < 0) {
                this.value = "";

            }
            if (this.value != "") {
                this.value = parseInt(this.value);
            }

            if (this.value > 365) {
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
    product.calculate('calculate-container', "percentage");
}