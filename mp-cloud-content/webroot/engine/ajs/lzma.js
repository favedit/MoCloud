"undefined"===typeof Worker||"undefined"!==typeof location&&"file:"===location.protocol?"undefined"!==typeof global&&"undefined"!==typeof require?this.LZMA=function(e){return require(e||"./lzma_worker-min.js").LZMA}:"undefined"!==typeof window&&window.document?function(){function e(b){var c;a(b);return c={compress:function(a,b,g,f){d.LZMA_WORKER?d.LZMA_WORKER.compress(a,b,g,f):setTimeout(function(){c.compress(a,b,g,f)},50)},decompress:function(a,b,g){d.LZMA_WORKER?d.LZMA_WORKER.decompress(a,b,g):
setTimeout(function(){c.decompress(a,b,g)},50)}}}var b=this,d,a=function(a){var c=document.createElement("script");c.type="text/javascript";c.src=a;c.onload=function(){b.LZMA=e};document.getElementsByTagName("head")[0].appendChild(c)};"undefined"!==typeof window?d=window:global&&(d=global);b.LZMA=e}():console.log("Can't load the worker. Sorry."):this.LZMA=function(e){var b={},d=new Worker(e||"./lzma_worker-min.js");d.onmessage=function(a){if(3===a.data.action){if(b[a.data.callback_num]&&"function"===
typeof b[a.data.callback_num].on_progress)b[a.data.callback_num].on_progress(a.data.result)}else b[a.data.callback_num]&&"function"===typeof b[a.data.callback_num].on_finish&&(b[a.data.callback_num].on_finish(a.data.result),delete b[a.data.callback_num])};d.onerror=function(a){throw Error(a.message+" ("+a.filename+":"+a.lineno+")");};return function(){function a(a,c,e,h,k){var f;do f=Math.floor(1E7*Math.random());while("undefined"!==typeof b[f]);b[f]={on_finish:h,on_progress:k};d.postMessage({action:a,
callback_num:f,data:c,mode:e})}return{compress:function(b,c,d,e){a(1,String(b),c,d,e)},decompress:function(b,c,d){a(2,b,!1,c,d)}}}()};