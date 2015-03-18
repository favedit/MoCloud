function MDataField(o){
   o = RClass.inherits(this, o, MDataValue);
   o._dataName = RClass.register(o, new APtyString('_dataName'));
   return o;
}
function MDataset(o){
   o = RClass.inherits(this, o, MDataContainer);
   o._dsDataset         = RClass.register(o, new APtyString('_dsDataset', 'dataset'));
   o._dsPageSize        = RClass.register(o, new APtyInteger('_dsPageSize', 'page_size'), 20);
   o._dsInsertAction    = RClass.register(o, new APtyString('_dsInsertAction', 'insert_action'));
   o._dsUpdateAction    = RClass.register(o, new APtyString('_dsUpdateAction', 'update_action'));
   o._dsDeleteAction    = RClass.register(o, new APtyString('_dsDeleteAction', 'delete_action'));
   o._dataSource        = null;
   o.onDsFetch          = MDataset_onDsFetch;
   o.onDatasetLoadBegin = RMethod.empty;
   o.onDatasetLoad      = RMethod.empty;
   o.onDatasetLoadEnd   = RMethod.empty;
   o.oeDataLoad         = MDataset_oeDataLoad;
   o.oeDataSave         = MDataset_oeDataSave;
   o.oeDatasetLoad      = MDataset_oeDatasetLoad;
   o.construct          = MDataset_construct;
   o.loadDataset        = MDataset_loadDataset;
   o.loadDatasets       = MDataset_loadDatasets;
   o.dsDatasetLoad      = MDataset_dsDatasetLoad;
   o.dsFetch            = MDataset_dsFetch;
   return o;
}
function MDataset_onDsFetch(g){
   var o = this;
   var ds = g.datasets;
   o.dsDatasetLoad(ds);
}
function MDataset_oeDataLoad(p){
   var o = this;
   if(p.isBefore()){
      var ds = p.source;
      ds.selectDataset();
      ds.selectRow();
   }
   return EEventStatus.Contine;
}
function MDataset_oeDataSave(p){
   var o = this;
   if(p.isBefore()){
      var ds = p.source;
      ds.selectDataset();
      ds.selectRow();
   }
   return EEventStatus.Contine;
}
function MDataset_oeDatasetLoad(p){
   var o = this;
   if(p.isBefore()){
      var ds = p.datasets;
      var d = ds.get(o._name);
      o._dataset = d;
      o.onDatasetLoad(d);
   }
   return EEventStatus.Contine;
}
function MDataset_construct(){
   var o = this;
}
function MDataset_loadDataset(d){
   var o = this;
   o.dsStore = d;
   d.saveViewer(o.dsViewer);
   o.onLoadDataset(d);
}
function MDataset_loadDatasets(p){
   var o = this;
   var c = p.count();
   for(var i = 0; i < c; i++){
      var d = p.value(n);
      var dc = o.findByPath(d.name)
      if(!dc){
         return RMessage.fatal(o, null, 'Load dataset failed. (dataset={1}', d.name);
      }
      dc.loadDataset(d);
   }
}
function MDataset_dsDatasetLoad(p){
   var o = this;
   var e = new TEventProcess(null, o, 'oeDatasetLoad', MDataset);
   e.datasets = p;
   o.process(e);
   e.dispose();
}
function MDataset_dsFetch(){
   var o = this;
   var g = new TDatasetFetchArg();
   g.owner = o;
   g.name = o._name;
   g.callback = o.onDsFetch;
   RConsole.find(FDatasetConsole).fetch(g);
}
function MDataset_onDsPrepare(g){
   var o = this;
   g.resultDatasets.set('/', null);
   o.loadDatasets(g.resultDatasets);
   o.doPrepare(g.resultRow);
   if(g.invokeSuccess()){
	   return;
   }
   o.onLoadDatasetEnd();
   o.focus();
}
function MDataset_onDsUpdate(g){
   var o = this;
   o.loadDatasets(g.resultDatasets);
   o.onLoadDatasetEnd();
   o.focus();
}
function MDataset_onDsCopy(g){
   var o = this;
   o.loadDatasets(g.resultDatasets);
   o.onLoadDatasetEnd();
   o.focus();
}
function MDataset_onDsDelete(g){
   var o = this;
   o.loadDatasets(g.resultDatasets);
   o.doDelete(g.resultRow);
   o.onLoadDatasetEnd();
   o.focus();
}
function MDataset_onDsProcess(g){
   var o = this;
   var cb = g.resultCallback;
   if(cb){
      cb.invoke(o, g);
   }
}
function MDataset_toDeepAttributes(a, m){
   var o = this;
   if(!a){
      a = new TAttributes();
   }
   var ts = new TList();
   var p = o;
   while(p){
      if(RClass.isClass(p, MDataset)){
         ts.push(p);
      }
      if(!p.parent){
         break;
      }
      p = p.topControl(MDataset);
   }
   for(var n=ts.count; n>=0; n--){
      var p = ts.get(n);
      if(RClass.isClass(p, FForm)){
         p.toAttributes(a, m);
      }else if(RClass.isClass(m, FTable)){
         var r = p.getCurrentRow();
         if(r){
            r.toAttributes(a, m);
         }
      }
   }
   return a;
}
function MDataset_onDsDoUpdate(g){
   var o = this;
   if(!g.invokeSuccess()){
      o.psRefresh();
   }
   if(!g.processFinish){
      o.focus();
      o.lsnsUpdateEnd.process(g);
   }
   o.onLoadDatasetEnd();
}
function MDataset_dsInitialize(){
   this.callEvent('onFormInitialize', this, this.__initializeEvent);
}
function MDataset_dsShow(){
   this.callEvent('onFormShow', this, this.__showEvent);
}
function MDataset_dsLoaded(){
   this.callEvent('onDatasetLoaded', this, this.__loadedEvent);
}
function MDataset_dsSearch(s){
   var o = this;
   o.psProgress(true);
   var tc = o.topControl();
   var pth = o.fullPath();
   if(s){
      pth = s.fullPath();
   }
   var g = new TDatasetFetchArg(tc.name, tc.formId, o.dsPageSize, 0, true, false, pth);
   g.mode = tc._emode;
   g.searchs.append(o.dsGlobalSearchs);
   g.searchs.append(o.dsSearchs);
   g.orders.append(o.dsGlobalOrders);
   g.orders.append(o.dsOrders);
   o.toDeepAttributes(g.values);
   g.values.append(o.dsValues);
   g.callback = new TInvoke(o, o.onDsFetch);
   RConsole.find(FDatasetConsole).fetch(g);
}
function MDataset_dsCopy(r){
   var o = this;
   o.psProgress(true);
   o.psMode(EMode.Insert);
   var g = new TDatasetFetchArg(o.name, o.formId, o.dsPageSize, 0, true);
   g.form = o;
   g.mode = EMode.Insert;
   o.dsSearchs.clear();
   o.dsSearchs.push(new TSearchItem('OUID', r.get("OUID")));
   g.searchs = o.dsSearchs;
   g.callback = new TInvoke(o, o.onDsCopy);
   if(o.onDsUpdateCheck(g)){
      RConsole.find(FDatasetConsole).fetch(g);
   }
   return;
}
function MDataset_dsPrepare(cb){
   var o = this;
   o.psProgress(true);
   o.psMode(EMode.Insert);
   var g = new TDatasetPrepareArg(o.name, o.formId);
   g.form = o;
   g.values.append(o.dsValues);
   g.callbackSuccess = cb;
   if(o.onDsPrepareCheck(g)){
      g.callback = new TInvoke(o, o.onDsPrepare);
      RConsole.find(FDatasetConsole).prepare(g);
   }
}
function MDataset_dsUpdate(u, v){
   var o = this;
   o.psProgress(true);
   o.psMode(EMode.Update);
   o.dsFetch(true);
}
function MDataset_dsDelete(u, v){
   var o = this;
   o.psProgress(true);
   o.psMode(EMode.Delete);
   var g = new TDatasetFetchArg(o.name, o.formId, o.dsPageSize, 0, true);
   g.callback = new TInvoke(o, o.onDsDelete);
   g.form = o;
   g.mode = EMode.Delete;
   if(u){
      g.searchs.push(new TSearchItem('OUID', u));
   }
   if(v){
       g.searchs.push(new TSearchItem('OVER', v));
   }
   g.values = o.dsValues;
   if(o.onDsDeleteCheck(g)){
      RConsole.find(FDatasetConsole).fetch(g);
   }
   return;
}
function MDataset_dsMode(m){
   var o = this;
   switch(m){
      case EMode.Insert:
         o.dsPrepare();
         break;
      case EMode.Update:
         o.dsUpdate();
         break;
      case EMode.Delete:
         o.dsDelete();
         break;
   }
}
function MDataset_dsDoUpdate(cb, ck){
   var o = this;
   if(!o.psValid()){
      return;
   }
   var t = o.topControl();
   var g = new TDatasetUpdateArg(t.name, o.formId, o.dsName);
   g.form = o;
   g.path = o.fullPath();
   g.mode = o._emode;
   g.codes = o.getDataCodes();
   g.callback = new TInvoke(o, o.onDsDoUpdate);
   g.callbackSuccess = cb;
   if(EMode.Insert == o._emode || EMode.Delete == o._emode){
      g.dataset.rows.append(o.getCurrentRows());
   }else{
      g.dataset.rows.append(o.getChangedRows());
      if(!ck){
         if(!g.hasData()){
            return RMessage.warn(o, RContext.get('MDataset:nochange'));
         }
      }
   }
   o.psProgress(true);
   RConsole.find(FDatasetConsole).update(g);
}
function MDataset_dsProcess(da, cb){
   var o = this;
   if(!o.psValid()){
      return;
   }
   var g = new TDatasetServiceArg(o.topControl().name, da);
   g.form = o;
   g.controlName = o.name;
   o.toDeepAttributes(g.attributes);
   g.codes = o.getDataCodes();
   g.push(o.getCurrentRow());
   g.resultCallback = cb;
   o.psProgress(true);
   g.callback = new TInvoke(o, o.onDsProcess);
   RConsole.find(FFormConsole).process(g);
}
function MDataset_dsProcessCustom(pm, da, cb, cc){
	var o = this;
	if(!cc){
	if(!o.psValid()){
	   return;
	}
	}
	var g = new TDatasetServiceArg(o.topControl().name, da);
	g.form = o;
	g.controlName = o.name;
	g.attributes = pm;
	g.codes = o.getDataCodes();
	g.push(o.getCurrentRow());
	g.resultCallback = cb;
	if(!cc){
	   if(!g.hasData()){
	      return RMessage.warn(o, RContext.get('MDataset:nodata'));
	   }
	}
	o.psProgress(true);
	g.callback = new TInvoke(o, o.onDsProcess);
	RConsole.find(FFormConsole).process(g);
}
function MDataset_dsProcessSelected(da, cb){
	var o = this;
	if(!o.psValid()){
	   return;
	}
	   var g = new TDatasetServiceArg(o.topControl().name, da);
	   g.form = o;
	   g.controlName = o.name;
	   o.toDeepAttributes(g.attributes);
	   g.codes = o.getDataCodes();
	   g.rows = o.getSelectedRows();
	   if(g.rows.count > 0){
		  g.resultCallback = cb;
		  o.psProgress(true);
		  g.callback = new TInvoke(o, o.onDsProcess);
		  RConsole.find(FFormConsole).process(g);
		  o.clearSelectRows();
	   }else{
	      return RMessage.warn(o, RContext.get('MDataset:norows'));
	   }
}
function MDataset_dsProcessChanged(da, cb){
   var o = this;
   if(!o.psValid()){
      return;
   }
   var g = new TDatasetServiceArg(o.topControl().name, da);
   g.form = o;
   g.controlName = o.name;
   o.toDeepAttributes(g.attributes);
   g.codes = o.getDataCodes();
   g.rows = o.getChangedRows();
   g.resultCallback = cb;
   if(!g.hasData()){
      return RMessage.warn(o, RContext.get('MDataset:nochange'));
   }
   o.psProgress(true);
   g.callback = new TInvoke(o, o.onDsProcess);
   RConsole.find(FFormConsole).process(g);
}
function MDataset_dsProcessAll(da, cb){
   var o = this;
   if(!o.psValid()){
      return;
   }
   var g = new TDatasetServiceArg(o.topControl().name, da);
   g.form = o;
   g.controlName = o.name;
   o.toDeepAttributes(g.attributes);
   g.codes = o.getDataCodes();
   g.rows = o.getRows();
   g.resultCallback = cb;
   o.psProgress(true);
   g.callback = new TInvoke(o, o.onDsProcess);
   RConsole.find(FFormConsole).process(g);
}
function MDataset_psProgress(v){
   var o = this;
   if(o.__progress == v){
      return;
   }
   o.__progress = v;
   var e = o.__progressProcess;
   e.enable = v;
   o.process(e);
}
function MDataset_psValid(){
   var o = this;
   var e = o.__validProcess;
   var cs = e.controls;
   cs.clear();
   o.process(e);
   if(!cs.isEmpty()){
      var cw = RConsole.find(FCheckWindowConsole).find();
      cw.set(cs);
      cw.show();
      return false;
   }
   return true;
}
function MDataset_dsCurrent(){
   var o = this;
   var ds = o.dsStore;
}
function MDataset_dsIsChanged(){
   var ds = this.dsStore;
   return ds ? ds.isChanged() : false;
}
function MDataset_dsCount(){
   return this.dsStore ? this.dsStore.count : 0;
}
function MDataset_dsMove(p){
   var o = this;
   var ds = o.dsStore;
   if(null == p && !ds){
      return;
   }
   if(!RInt.isInt(p)){
      if(EDataAction.First == p){
         ds.moveFirst();
      }else if(EDataAction.Prior == p){
         ds.movePrior();
      }else if(EDataAction.Next == p){
         ds.moveNext();
      }else if(EDataAction.Last == p){
         ds.moveLast();
      }else{
         RMessage.fatal(o, null, 'Unknown position (postion={0})', p);
      }
   }else{
      ds.move(p);
   }
   if(RClass.isClass(o, MValue)){
      o.loadValue(ds.current());
   }
}
function MDataset_dsMovePage(p){
   var o = this;
   var ds = o.dsStore;
   if(!RInt.isInt(p)){
      if(EDataAction.First == p){
         p = 0;
      }else if(EDataAction.Prior == p){
         p = ds.pageIndex;
         if(p > 0){
            p--;
         }
      }else if(EDataAction.Next == p){
         p = ds.pageIndex;
         if(p < ds.pageCount - 1){
            p++;
         }
      }else if(EDataAction.Last == p){
         p = ds.pageCount - 1;
      }else{
         RMessage.fatal(o, null, 'Unknown page (page={0})', p);
      }
   }
   if(p != ds.pageIndex){
      o.psProgress(true);
      var t = o.topControl(MDataset);
      var g = new TDatasetFetchArg(t.name, t.formId, o.dsPageSize, p, true);
      g.path =  o.fullPath();
      g.mode = t._emode;
      g.searchs.append(o.dsGlobalSearchs);
      g.searchs.append(o.dsSearchs);
      g.orders.append(o.dsGlobalOrders);
      g.orders.append(o.dsOrders);
      g.values = o.toDeepAttributes();
      g.values.append(o.dsValues);
      g.callback = new TInvoke(o, o.onDsFetch);
      RConsole.find(FDatasetConsole).fetch(g);
   }
}
function MDataset_dsGet(n){
   return this.dsStore ? this.dsStore.get(n) : '';
}
function MDataset_dsSet(n, v){
   if(this.dsStore){
      this.dsStore.set(n, v);
   }
}
function MDataset_dsRefresh(){
   if(this.dsService){
      this.dsMove(this.dsPage, true);
   }
}
function MDataset_doSearch(){
   var o = this;
   var sw = o.dsSearchWindow;
   if(!sw){
      sw = o.dsSearchWindow = top.RControl.create(top.FSearchWindow);
      sw.linkDsControl(o);
   }
   sw.show();
}
function FDatasetConsole(o){
   o = RClass.inherits(this, o, FConsole);
   o._scopeCd = EScope.Local;
   o._service = 'cloud.data.frame';
   o._datasets        = null;
   o.onFetch  = FDatasetConsole_onFetch;
   o.construct        = FDatasetConsole_construct;
   o.loadDataset      = FDatasetConsole_loadDataset;
   o.loadDatasets     = FDatasetConsole_loadDatasets;
   o.fetch    = FDatasetConsole_fetch;
   return o;
}
function FDatasetConsole_onFetch(p){
   var o = this;
   var g = p.parameter;
   var x = p.outputNode;
   if(x.hasNode()){
      o.loadDatasets(x);
      var dss = g.datasets;
      var xns = x.nodes();
      var xnc = xns.count();
      for(var i = 0; i < xnc; i++){
         var xn = xns.get(i);
         var n = xn.get('name');
         var d = o._datasets.get(n);
         dss.set(n, d);
      }
   }
   g.process();
}
function FDatasetConsole_construct(){
   var o = this;
   o.__base.FConsole.construct.call(o);
   o._datasets = new TDictionary();
}
function FDatasetConsole_loadDataset(x){
   var o = this;
   var n = x.get('name');
   if(RString.isEmpty(n)){
      throw new TError('Unknown dataset name.');
   }
   var d = o._datasets.get(n);
   if(!d){
      d = new TDataset();
      d.name = n;
      o._datasets.set(n, d);
   }
   d.clear();
   d.loadConfig(x);
   return d;
}
function FDatasetConsole_loadDatasets(p){
   var o = this;
   if(p.hasNode()){
      var xs = p.nodes();
      var c = xs.count();
      for(var i = 0; i < c; i++){
         var x = xs.get(i);
         if(x.isName('Dataset')){
            o.loadDataset(x);
         }
      }
   }
}
function FDatasetConsole_fetch(p){
   var o = this;
   var xd = new TXmlDocument();
   var xr = xd.root();
   xr.set('action', 'fetch');
   p.saveConfig(xr.create('Frame'));
   var e = new SXmlEvent();
   e.owner = o;
   e.url = RService.url(o._service);
   e.action = EDataAction.Fetch;
   e.parameter = p;
   e.inputDocument = xd;
   e.callback = o.onFetch;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_onScalarLoaded(g, r){
   var o = this;
   if(r.hasNode()){
      var rc = g.resultConfig = r.find('Control');
      if(rc){
         g.result = rc.get('result');
      }
   }
   g.invoke();
}
function FDatasetConsole_scalar(g){
   var o = this;
   var doc = new TXmlDocument();
   var r = doc.root();
   r.set('action', EDataAction.Scalar);
   r.push(g.toNode());
   var e = new TEvent(o, EXmlEvent.Send, o.onLoaded);
   e.url = RService.url('logic.webform.dataset');
   e.action = EDataAction.Scalar;
   e.argument = g;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_onCompleteLoaded(g, root){
   var o = this;
   if(root.hasNode()){
      var nc = root.find('Control');
      if(nc){
         g.resultConfig = nc;
      }
   }
   g.invoke();
}
function FDatasetConsole_onLovLoadeded(arg, root){
   var o = this;
   arg.lovNode = root;
   arg.invoke();
}
function FDatasetConsole_onPrepareLoaded(g, x){
   var o = this;
   var rds = g.resultDatasets;
   if(x.hasNode()){
      var xfs = x.nodes;
      var xfc = xfs.count;
      for(var n = 0; n < xfc; n ++){
         var xf = xfs.get(n);
         var fd = xf.get('id');
         if(!RString.isEmpty(fd)){
            o.loadDatasets(rds, fd, xf);
         }
      }
   }
   if(!rds.isEmpty()){
      var c = rds.count;
      for(var n=0; n<c; n++){
         var rd = rds.value(n);
         if('/' == rd.name){
            g.resultRow = rd.row(0);
            break;
         }
      }
   }
   g.invoke();
}
function FDatasetConsole_onUpdateLoaded(g, x){
   var o = this;
   var xf = x.find('Form');
   if(!xf){
      return;
   }
   var fd = xf.get('id');
   var xd = xf.find('Dataset');
   if(!xd){
      return;
   }
   var ds = g.resultDataset = o.loadDataset(fd, xd);
   g.resultRow = ds.row(0);
   g.invoke();
   RWindow.setEnable(true);
}
function FDatasetConsole_onLoaded(e){
   var o = this;
   var r = e.document.root();
   var g = e.argument;
   if(!e.messageChecked){
      var m = new TMessageArg();
      m.argument = g;
      m.form = g.form;
      m.config = r;
      m.invokeCaller = new TInvoke(o, o.onLoaded);
      m.invokeParam = e;
      m.event = e;
      if(!RConsole.find(FMessageConsole).checkResult(m)){
         return;
      }
   }
   g.configResult = r;
   switch(e.action){
      case EDataAction.Fetch:
         o.onFetchLoaded(g, r);
         break;
      case EDataAction.Prepare:
         o.onPrepareLoaded(g, r);
         break;
      case EDataAction.Update:
         o.onUpdateLoaded(g, r);
         break;
      case EDataAction.Lov:
         o.onLovLoaded(g, r);
         break;
      case EDataAction.Scalar:
         o.onScalarLoaded(g, r);
         break;
      case EDataAction.Complete:
         o.onCompleteLoaded(g, r);
         break;
   }
   RConsole.find(FListenerConsole).process(MDataset, EAction.Changed, e, e)
}
function FDatasetConsole_complete(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', 'complete');
   root.push(g.toNode());
   var e = new TEvent(o, EXmlEvent.Send, o.onLoaded);
   e.url = RService.url('logic.webform.dataset');
   e.action = EDataAction.Complete;
   e.argument = g;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_lov(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', 'lov');
   root.push(g.toNode());
   var e = new TEvent(o, EXmlEvent.Send, o.onLoaded);
   e.url = RService.url('logic.webform.dataset');
   e.action = EDataAction.Lov;
   e.argument = g;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_prepare(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', 'prepare');
   root.push(g.toNode());
   var e = new TEvent(o, EXmlEvent.Send, o.onLoaded);
   e.url = RService.url('logic.webform.dataset');
   e.action = EDataAction.Prepare;
   e.argument = g;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_update(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', 'update');
   if(g.checked){
      root.set('checked', g.checked);
   }
   root.push(g.toNode());
   var e = new TEvent(o, EXmlEvent.Send, o.onLoaded);
   e.url = RService.url('logic.webform.dataset');
   e.action = EDataAction.Update;
   e.argument = g;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_get(id){
   var o = this;
   var ds = o.forms.get(id);
   return ds;
}
function FDatasetConsole_getById(id){
   var o = this;
   var d = o._datasets.get(id);
   return d;
}
function FDatasetConsole_getByPath(formId, path){
   var o = this;
   var ds = o.get(formId);
   return ds ? ds.get(path) : null;
}
function FDatasetConsole_onTreeLoaded(g){
   var o = this;
   alert(1);
}
function FDatasetConsole_onColumnFetch(e){
   var o = this;
   var root = e.document.root();
   var mc = RConsole.find(FMessageConsole);
   var r = mc.checkResult(root);
   if(r){
      var g = e.arg;
      if(root.hasNode()){
         var fs = root.nodes;
         var ct = fs.count;
         for(var k = 0; k < ct; k++){
            var f = fs.get(k);
            if(f.hasNode()){
               var ns = f.nodes;
               var nt = ns.count;
               for( n = 0; n < nt; n++){
                  var d = ns.get(n);
                  if(d.name == 'Data'){
                     g.resultConfig = d;
                     break;
                  }
               }
            }
         }
      }
      g.invoke();
   }
}
function FDatasetConsole_columnNodeFetch(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', g.action);
   var nd = g.toNode();
   root.push(nd);
   var url = RService.url(g.service);
   var e = new TEvent(o, EXmlEvent.Send, o.onColumnFetch);
   e.url = url;
   e.document = doc;
   e.arg = g;
   e.action = EDataAction.Fetch;
   RConsole.find(FXmlConsole).process(e);
}
function FDatasetConsole_treeUpdate(g){
   var o = this;
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', g.action);
   var nd = g.toNode();
   root.push(nd);
   var url = RService.url(g.service);
   var e = new TEvent(o, EXmlEvent.Send, o.onTreeLoaded);
   e.url = url;
   e.document = doc;
   e.arg = g;
   e.action = EDataAction.TreeUpdate;
   RConsole.find(FXmlConsole).process(e);
}
function FDataSource(o){
   o = RClass.inherits(this, o, FObject);
   o._currentRow     = null;
   o._currentDataset = null;
   o._datasets       = null;
   o.construct       = FDataSource_construct;
   o.selectDataset   = FDataSource_selectDataset;
   o.currentDataset  = FDataSource_currentDataset;
   o.selectRow       = FDataSource_selectRow;
   o.currentRow      = FDataSource_currentRow;
   return o;
}
function FDataSource_construct(){
   var o = this;
   o.__base.FObject.construct.call(o);
   o._datasets = new TDictionary();
}
function FDataSource_selectDataset(p){
   var o = this;
   var dn = RString.nvl(p, 'default');
   var d = o._datasets.get(dn);
   if(d == null){
      d = new TDataset();
      d._name = dn;
      o._datasets.set(dn, d);
   }
   o._currentDataset = d;
}
function FDataSource_currentDataset(){
   return this._currentDataset;
}
function FDataSource_selectRow(p){
   var o = this;
   if(p){
      o._currentRow = p;
      return;
   }
   var d = o._currentDataset;
   var r = d.rows().first();
   if(r == null){
      r = d.createRow();
   }
   o._currentRow = r;
   return r;
}
function FDataSource_currentRow(){
   return this._currentRow;
}
function FDataSource_create(c){
   return this.dataset.create(c);
}
function FDataSource_count(){
   return this.dataset.count;
}
function FDataSource_row(n){
   return this.dataset.get(n);
}
function FDataSource_current(){
   return this.row(this._position);
}
function FDataSource_isChanged(){
   var o = this;
   var d = o.dataset;
   for(var n=0; n<d.count; n++){
      var r = d.get(n);
      if(r && r.isSave()){
         return true;
      }
   }
   return false;
}
function FDataSource_get(n){
   var r = this.current();
   return r ? r.get(n) : '';
}
function FDataSource_set(n, v){
   var r = this.current();
   if(r){
      r.set(n, v);
   }
}
function FDataSource_move(p){
   this._position = p;
}
function FDataSource_moveToRow(row){
   var p = this.dataset.indexOf(row);
   if(-1 != p){
      this._position = p;
   }
}
function FDataSource_find(){
   return this.dataset.findByArgs(arguments);
}
function FDataSource_loadNode(config){
   if(config && config.nodes){
      var nodes = config.nodes;
      for(var n=0; n<nodes.count; n++){
         var node = nodes.get(n);
         if(node && node.isName('Row')){
            var row = this.dataset.create();
            row.loadNode(node);
            row.store();
         }
      }
   }
}
function FDataSource_dump(s){
   var o = this;
   s = RString.nvlStr(s);
   s.appendLine(RClass.dump(o));
   o.dataset.dump(s);
   return s;
}
function FUiDataAction(o){
   o = RClass.inherits(this, o, FUiComponent);
   o._action = RClass.register(o, new APtyString('_action'));
   return o;
}
function FUiDataEdit(o){
   o = RClass.inherits(this, o, FUiEdit);
   o._inputSize       = RClass.register(o, new APtySize2('_inputSize'));
   o._styleInputPanel = RClass.register(o, new AStyle('_styleInputPanel'));
   o._styleInput      = RClass.register(o, new AStyle('_styleInput'));
   o._hInput          = null;
   o.onBuildEditValue = FUiDataEdit_onBuildEditValue;
   o.onInputEdit      = RClass.register(o, new AEventInputChanged('onInputEdit'), FUiDataEdit_onInputEdit);
   o.construct        = FUiDataEdit_construct;
   o.get              = FUiDataEdit_get;
   o.set              = FUiDataEdit_set;
   o.refreshValue     = FUiDataEdit_refreshValue;
   return o;
}
function FUiDataEdit_oeDataLoad(p){
   var o = this;
   return EEventStatus.Stop;
}
function FUiDataEdit_oeDataSave(p){
   var o = this;
   return EEventStatus.Stop;
}
function FUiDataEdit_onBuildEditValue(p){
   var o = this;
   var h = o._hValuePanel;
   h.className = o.styleName('InputPanel');
   var he = o._hInput = RBuilder.appendEdit(h, o.styleName('Input'));
   if(o._editLength){
      he.maxLength = o._editLength;
   }
}
function FUiDataEdit_onInputEdit(p){
   var o = this;
   var v = o._hInput.value;
   o.refreshValue();
}
function FUiDataEdit_construct(){
   var o = this;
   o.__base.FUiEdit.construct.call(o);
   o._inputSize = new SSize2(120, 0);
}
function FUiDataEdit_get(){
   var o = this;
   var r = o.__base.FUiEdit.get.call(o);
   var h = o._hInput;
   if(h){
      r = h.value;
   }
   return r;
}
function FUiDataEdit_set(p){
   var o = this;
   o.__base.FUiEdit.set.call(o, p);
   var h = o._hInput;
   if(h){
      h.value = RString.nvl(p);
   }
}
function FUiDataEdit_refreshValue(){
   var o = this;
   o.processDataChangedListener(o);
}
function FUiDataEdit_onDataKeyDown(s, e){
   var o = this;
   o.__base.FUiEdit.onDataKeyDown.call(o, s, e);
   if(o.editCase){
      RKey.fixCase(e, o.editCase);
   }
   if(o._editable){
      return;
      if(o.editComplete){
         if( 16 != e.keyCode && 17 != e.keyCode && 18 != e.keyCode && 20 != e.keyCode ){
            var ed = o.findEditor();
            if(ed){
               ed.onEditKeyDown(s, e);
            }
         }
      }
   }
}
function FUiDataEdit_formatValue(v){
   var o = this;
   var r = RString.nvl(v);
   if(ECase.Upper == o.editCase){
      r = RString.toUpper(r);
   }else if(ECase.Lower == o.editCase){
      r = RString.toLower(r);
   }
   return r;
}
function FUiDataEdit_setText(t){
   var o = this;
   if(!o.hEdit){
      return;
   }
   if('U'== o.editCase){
      o.hEdit.value = RString.toUpper(t);
   }else if('L'== o.editCase){
         o.hEdit.value = RString.toLower(t);
   }else{
      o.hEdit.value = t;
   }
   if('right' == o.editAlign){
      o.hEdit.style.textAlign = 'right';
   }else if('left' == o.editAlign ){
      o.hEdit.style.textAlign = 'left';
   }else{
      o.hEdit.style.textAlign = 'center';
   }
}
function FUiDataEdit_validText(t){
   var o = this;
   var r = o.__base.FUiEdit.validText.call(o, t);
   if(!r){
      if(o.validLenmin){
         if(o.validLenmin > t.length){
            return RContext.get('MDescEdit:ValidMinLength', o.validLenmin);
         }
      }
      if(o.validLenmax){
         if(o.validLenmax < t.length){
            return RContext.get('MDescEdit:ValidMaxLength', o.validLenmax);
         }
      }
   }
   return r;
}
function FUiDataEdit_findEditor(){
   var o = this;
   if(o.editComplete){
      var de = o.editor;
      if(!de){
         o.dsControl = o.topControl(MDataset);
         if(o.dsControl){
            de = o.editor = RConsole.find(FUiDataEditConsole).focus(o, FUiDataEditEditor);
         }
      }
      if(de){
         de.linkControl(o);
      }
      return o.editor;
   }
}
function FUiDataEdit_drop(){
   var o = this;
   var de = o.findEditor();
   if(de){
      var t = o.reget();
      if(t.length > 0){
         if(o.finded != t){
            if(de.source != o){
               de.linkControl(o);
            }
            de.search(t);
         }
         o.finded = t;
      }
   }
}
function FUiDataEdit_clone(){
   var o = this;
   var r = o._class.newInstance();
   GHtml_clone(r, o.hPanel);
   return r;
}
function FUiDataEdit_link(){
   var o = this;
}
function FUiDataEditControl(o){
   o = RClass.inherits(this, o, FUiEditControl, MDataField, MEditValue, MEditChange, MEditDrop);
   o._labelModeCd      = RClass.register(o, new APtyString('_labelModeCd'), ELabelMode.All);
   o._labelPositionCd  = RClass.register(o, new APtyString('_labelPositionCd'), ELabelPosition.Left);
   o._labelSize        = RClass.register(o, new APtySize2('_labelSize'));
   o._labelAlignCd     = RClass.register(o, new APtyString('_labelAlignCd'), EAlign.Left);
   o._editSize         = RClass.register(o, new APtySize2('_editSize'));
   o._dataTypeCd       = RClass.register(o, new APtyString('_dataTypeCd'));
   o._styleLabelPanel  = RClass.register(o, new AStyle('_styleLabelPanel'));
   o._styleEditPanel   = RClass.register(o, new AStyle('_styleEditPanel'));
   o._hLabelPanel      = null;
   o._hLabelForm       = null;
   o._hIconPanel       = null;
   o._hIcon            = null;
   o._hTextPanel       = null;
   o._hText            = null;
   o._hEditPanel       = null;
   o._hEditForm        = null;
   o._hValuePanel      = null;
   o.onBuildLabelIcon  = FUiDataEditControl_onBuildLabelIcon;
   o.onBuildLabelText  = FUiDataEditControl_onBuildLabelText;
   o.onBuildLabel      = FUiDataEditControl_onBuildLabel;
   o.onBuildEditValue  = RMethod.virtual(o, 'onBuildEditValue');
   o.onBuildEdit       = FUiDataEditControl_onBuildEdit;
   o.onBuildPanel      = FUiDataEditControl_onBuildPanel;
   o.onBuild           = FUiDataEditControl_onBuild;
   o.oeDataLoad        = FUiDataEditControl_oeDataLoad;
   o.oeDataSave        = FUiDataEditControl_oeDataSave;
   o.oeDesign          = FUiDataEditControl_oeDesign;
   o.oeMode            = FUiDataEditControl_oeMode;
   o.construct         = FUiDataEditControl_construct;
   o.panel             = FUiDataEditControl_panel;
   o.label             = FUiDataEditControl_label;
   o.setLabel          = FUiDataEditControl_setLabel;
   o.getEditRange    = FUiDataEditControl_getEditRange;
   o.dispose           = FUiDataEditControl_dispose;
   return o;
}
function FUiDataEditControl_onBuildLabelIcon(p){
   var o = this;
   if(o._labelIcon){
      o._hIcon = RBuilder.appendIcon(o._hIconPanel, o._labelIcon);
   }
}
function FUiDataEditControl_onBuildLabelText(p){
   var o = this;
   o._hText = RBuilder.appendSpan(o._hTextPanel, null, o._label);
}
function FUiDataEditControl_onBuildLabel(p){
   var o = this;
   var h = o._hLabelForm = RBuilder.appendTable(o._hLabelPanel, o.styleName('LabelPanel'));
   var hr = RBuilder.appendTableRow(h);
   var hip = o._hIconPanel = RBuilder.appendTableCell(hr);
   o.onBuildLabelIcon(p);
   var htp = o._hTextPanel = RBuilder.appendTableCell(hr);
   htp.noWrap = true;
   o.onBuildLabelText(p);
   RHtml.setSize(h, o._labelSize);
   if(o._labelAlignCd){
      htp.align = o._labelAlignCd;
      htp.style.paddingRight = 4;
   }
   if(o._labelColor){
      o._hLabel.style.color = o._labelColor;
   }
}
function FUiDataEditControl_onBuildEdit(p){
   var o = this;
   var h = o._hEditForm = RBuilder.appendTable(o._hEditPanel, o.styleName('EditPanel'));
   var hr = o._hEditLine = RBuilder.appendTableRow(h);
   o._hValuePanel = RBuilder.appendTableCell(hr);
   o.onBuildEditValue(p);
   RHtml.setSize(h, o._editSize);
}
function FUiDataEditControl_onBuildPanel(p){
   var o = this;
   o._hPanel = RBuilder.createTable(p, o.styleName('Panel'));
}
function FUiDataEditControl_onBuild(p){
   var o = this;
   o.__base.FUiEditControl.onBuild.call(o, p);
   var hc = o._hPanel;
   var hlp = null;
   var hep = null;
   var lmc = o._labelModeCd;
   if(lmc == ELabelMode.Label){
      hlp = RBuilder.appendTableCell(RBuilder.appendTableRow(hc));
   }else if(lmc == ELabelMode.Hidden){
      hep = RBuilder.appendTableCell(RBuilder.appendTableRow(hc));
   }else{
      var lpc = o._labelPositionCd;
      if(lpc == ELabelPosition.Top){
         hlp = RBuilder.appendTableRowCell(hc);
         hep = RBuilder.appendTableRowCell(hc);
      }else if(lpc == ELabelPosition.Right){
         var hr = RBuilder.appendTableRow(hc);
         hep = RBuilder.appendTableCell(hr);
         hlp = RBuilder.appendTableCell(hr);
      }else if(lpc == ELabelPosition.Bottom){
         hep = RBuilder.appendTableRowCell(hc);
         hlp = RBuilder.appendTableRowCell(hc);
      }else{
         var hr = RBuilder.appendTableRow(hc);
         hlp = RBuilder.appendTableCell(hr);
         hep = RBuilder.appendTableCell(hr);
      }
   }
   o._hLabelPanel = hlp;
   o._hEditPanel = hep;
   if(hlp){
      o.onBuildLabel(p);
      hlp.appendChild(o._hLabelForm);
      o.setLabel(o._label);
   }
   if(hep){
      o.onBuildEdit(p);
   }
}
function FUiDataEditControl_getEditRange(){
   var o = this;
   var hc = o.hEditCell;
   var p = RHtml.offsetPosition(hc);
   var w = hc.offsetWidth;
   var h = hc.offsetHeight;
   return new TRange(p.x, p.y, w, h);
}
function FUiDataEditControl_onScalar(g){
   var o = this;
   o.set(g.result);
}
function FUiDataEditControl_scalar(a){
   var o = this;
   var g = new TDatasetScalarArg(o, null, a);
   g.callback = new TInvoke(o, o.onScalar);
   RConsole.find(FDatasetConsole).scalar(g);
}
function FUiDataEditControl_onDataDoubleClick(){
   var o = this;
   if(RClass.isClass(o, MDropable)){
      o.onDropDoubleClick();
   }
   if(RClass.isClass(o, MListView)){
      o.onListClick();
   }
}
function FUiDataEditControl_onDataKeyDown(s, e){
   var o = this;
   o.__base.MEditDescriptor.onDataKeyDown.call(o, s, e);
   var hci = o.hChangeIcon;
   if(hci){
      hci.style.display = o.isDataChanged() ? 'block' : 'none';
   }
   if(RClass.isClass(o, MDropable) && EKey.Down==e.keyCode){
      o.drop();
   }else if(e.ctrlKey && (EKey.Enter==e.keyCode) && o.editSearch){
      var dc = o.dsControl;
      if(dc){
         if(!o.isValid){
            var sn = new TNode('Search');
            var n = sn.create('Item');
            n.set('name', o.name);
            n.set('data_name', o.dataName);
            n.set('data_value', o.dataValue);
            n.set('search_type', ESearch.Equals);
            n.set('search_order', EOrder.None);
            RConsole.find(FDatasetConsole).fetch(dc, sn);
         }
      }
   }
}
function FUiDataEditControl_onDesignBegin(){
   var o = this;
   o.__base.MDesign.onDesignBegin.call(o);
   o._disbaled = true;
   o.hEdit.disbaled = true;
}
function FUiDataEditControl_onDesignEnd(){
   var o = this;
   o.__base.MDesign.onDesignEnd.call(o);
   o._disbaled = false;
   o.hEdit.disbaled = false;
}
function FUiDataEditControl_oeDataLoad(p){
   var o = this;
   var ds = p.source;
   var r = ds.currentRow();
   var v = r.get(o._dataName);
   o.set(v);
   return EEventStatus.Stop;
}
function FUiDataEditControl_oeDataSave(p){
   var o = this;
   var ds = p.source;
   var r = ds.currentRow();
   var v = o.get();
   r.set(o._dataName, v);
   return EEventStatus.Stop;
}
function FUiDataEditControl_oeDesign(p){
   var o = this;
   o.__base.MDesign.oeDesign.call(o, e);
   var hlf = o.hLabelForm;
   var hef = o.hEditForm;
   switch(e.mode){
      case EDesign.Move:
         if(e.flag){
            o.hForm.border = 1;
            if(hlf){
               hlf.cellPadding = 1;
            }
            if(hef){
            }
            if(o.hEdit){
               o.hEdit.disabled = true;
            }
         }else{
            o.hForm.border = 0;
            if(hlf){
               hlf.border = 0;
               hlf.cellPadding = 0;
            }
            if(hef){
            }
            if(o.hEdit){
               o.hEdit.disabled = false;
            }
         }
         break;
      case EDesign.Border:
         if(e.flag){
            o.hForm.border = 1;
            if(hef){
               hef.border = 1;
            }
         }else{
            o.hForm.border = 0;
            if(hef){
               hef.border = 0;
            }
         }
         break;
   }
   return EEventStatus.Stop;
}
function FUiDataEditControl_oeMode(e){
   var o = this;
   o.__base.FUiEditControl.oeMode.call(o, e);
   o.__base.MDisplay.oeMode.call(o, e);
   o._editable = o.canEdit(e.mode);
   o._validable = o.canValid(e.mode);
   if(!o._progress){
      o.setEditable(o._editable);
   }
   return EEventStatus.Stop;
}
function FUiDataEditControl_oeProgress(e){
   var o = this;
   if(o._progress && e.enable){
      return EEventStatus.Stop;
   }
   o._progress = e.enable;
   if(e.enable){
      var ea = o._editable;
      o.setEditable(false);
      o._editable = ea;
   }else{
      o.setEditable(o._editable);
   }
   return EEventStatus.Stop;
}
function FUiDataEditControl_oeLoadValue(e){
   var o = this;
   var r = o.__base.MEditValue.oeLoadValue.call(o, e);
   var hci = o.hChangeIcon;
   if(hci){
      hci.style.display = 'none';
   }
   return r;
}
function FUiDataEditControl_doFocus(e){
   var o = this;
   o.__base.MUiFocus.doFocus.call(o, e);
   o.__base.MEditValue.doFocus.call(o, e);
}
function FUiDataEditControl_doBlur(e){
   var o = this;
   o.__base.MUiFocus.doBlur.call(o, e);
   o.__base.MEditValue.doBlur.call(o, e);
}
function FUiDataEditControl_construct(){
   var o = this;
   o.__base.FUiEditControl.construct.call(o);
   o.__base.MEditChange.construct.call(o);
   o.__base.MEditDrop.construct.call(o);
   o._labelSize = new SSize2(100, 20);
   o._editSize = new SSize2(200, 20);
}
function FUiDataEditControl_panel(t){
   var o = this;
   if(EPanel.Edit == t){
      return o.hEdit;
   }else if(EPanel.Focus == t){
      return o.hEdit;
   }
   return o.__base.FUiEditControl.panel.call(o, t);
}
function FUiDataEditControl_label(p){
   return this._label;
}
function FUiDataEditControl_setLabel(p){
   var o = this;
   o._label = p;
   if(o._hText){
      o._hText.innerHTML = RString.nvl(p);
   }
}
function FUiDataEditControl_testFocus(){
   return this._visible && this._editable && !this._disbaled;
}
function FUiDataEditControl_text(){
   return this.hEdit ? this.hEdit.value : '';
}
function FUiDataEditControl_setText(t){
   this.hEdit.value = t;
}
function FUiDataEditControl_setEditable(v){
   var o = this;
   o.__base.MEditValue.setEditable.call(o, v);
   if(o.hEdit){
      o.hEdit.readOnly = !v;
   }
   var hl = o.hLabel;
   if(hl){
      if(o.validRequire){
         o.hLabel.style.color = v ? EColor.Require : EColor.Text;
      }
      if(RClass.isClass(o, MListView) && o.canListView()){
         hl.style.cursor = v ? 'hand' : 'normal';
         hl.className = v ? 'RLine_Underline' : '';
      }
   }
}
function FUiDataEditControl_setVisible(v){
   var o = this;
   o.__base.FUiEditControl.setVisible.call(o, v);
   o.refreshStyle();
}
function FUiDataEditControl_focus(){
   var o = this;
   o.__base.MUiFocus.focus.call(o);
   if(o.hEdit){
      try{
         o.hEdit.focus();
      }catch(e){
      }
   }
}
function FUiDataEditControl_refreshStyle(){
   var o = this;
   if(!o._visible){
      return;
   }
   var tc = EColor.TextReadonly;
   var bc = EColor.Readonly;
   var cr = 'normal';
   if(o._editable){
      tc = EColor.TextEdit;
      bc = EColor.Edit;
      cr = 'hand';
      if(!RString.isEmpty(o.editTip) && o.hEdit.innerText == o.editTip){
         tc = '#CCCCCC';
      }
   }
   if(o._invalidText){
      if(!RString.isEmpty(o.text())){
         tc = EColor.TextInvalid;
         bc = EColor.Invalid;
      }
   }
   o._textColor = tc;
   o._backColor = bc;
   var he = o.hEdit;
   var hd = o.hDrop;
   if(he){
      he.style.color = tc;
      he.style.backgroundColor = bc;
   }
   if(hd){
      if(he){
         he.style.cursor = cr;
      }
      hd.style.cursor = cr;
   }
   if(o.editBorder){
      var bs = EUiBorderStyle.Readonly;
      if(o._editable){
         bs = EUiBorderStyle.Edit;
      }
      if(o._hover){
         bs = EUiBorderStyle.Hover;
      }
      o.setEditBorderStyle(bs, bc);
   }
}
function FUiDataEditControl_dispose(){
   var o = this;
   o._labelModeCd = null;
   o._labelPositionCd = null;
   o._labelAlignCd = null;
   o._dataTypeCd = null;
   var v = o._labelSize;
   if(v){
      v.dispose();
      o._labelSize = null;
   }
   var v = o._editSize;
   if(v){
      v.dispose();
      o._editSize = null;
   }
   RHtml.free(o._hLabelPanel);
   o._hLabelPanel = null;
   RHtml.free(o._hLabelForm);
   o._hLabelForm = null;
   RHtml.free(o._hIconPanel);
   o._hIconPanel = null;
   RHtml.free(o._hIcon);
   o._hIcon = null;
   RHtml.free(o._hTextPanel);
   o._hTextPanel = null;
   RHtml.free(o._hText);
   o._hText = null;
   RHtml.free(o._hEditPanel);
   o._hEditPanel = null;
   RHtml.free(o._hEditForm);
   o._hEditForm = null;
   RHtml.free(o._hValuePanel);
   o._hValuePanel = null;
   RHtml.free(o._hDropPanel);
   o._hDropPanel = null;
   o.__base.MEditDrop.dispose.call(o);
   o.__base.MEditChange.dispose.call(o);
   o.__base.FUiEditControl.dispose.call(o);
}
function FUiDataFrame(o){
   o = RClass.inherits(this, o, FUiFrame);
   return o;
}
function FUiDataNumber(o){
   o = RClass.inherits(this, o, FEditControl);
   return o;
}
function FUiDataNumber_onEditFocus(e){
   var o = this;
   o.setText(o.formatValue(o.text()));
}
function FUiDataNumber_onEditBlur(e){
   var o = this;
   o.setText(o.formatText(o.text()));
}
function FUiDataNumber_onBuildEdit(b){
   var o = this;
   var htb = RBuilder.appendTable(b.hPanel);
   htb.style.tableLayout = 'fixed';
   var hr = o.hEdit = htb.insertRow();
   o.onBuildChange(hr.insertCell());
   if(o.canZoom()){
      var hc = hr.insertCell();
      o.hZoom = RBuilder.appendIcon(hc, 'ctl.zooms');
      hc.width = 16;
   }
   var hc = hr.insertCell();
   hc.style.width = '100%';
   var he = o.hEdit = RBuilder.appendEdit(hc, o.style('Edit'));
   o.attachEvent('onEditFocus', he, o.onEditFocus);
   o.attachEvent('onEditKeyPress', he, o.onEditKeyPress);
   o.attachEvent('onEditBlur', he, o.onEditBlur);
   o.attachEvent('onDataKeyUp', he, o.ohEditKeyUp);
   if(o.editLength){
      he.maxLength = o.editLength;
   }
   o.buildAdjustForm(b.hDrop);
}
function FUiDataNumber_setUnitIcon(i){
   var o = this;
   var hui = o.hUnit;
   hui.innerHTML = '<IMG src='+i+'>';
}
function FUiDataNumber_onDataKeyDown(s, e){
   var o = this;
   if(o.canEdit){
      if(EKey.Up == e.keyCode){
         o.adjustValue(true);
      }else if(EKey.Down == e.keyCode){
         o.adjustValue(false);
      }
   }
   o.base.FEditControl.onDataKeyDown.call(o, s, e);
}
function FUiDataNumber_ohEditKeyUp(s, e){
   var o = this;
   if(EKey.Up == e.keyCode && o.canEdit){
      o.hUpIcon.src = o.styleIconPath('UpSelect');
   }else if(EKey.Down == e.keyCode && o.canEdit){
      o.hDownIcon.src = o.styleIconPath('DownSelect');
   }
}
function FUiDataNumber_onEditKeyDown(e) {
   var o = this;
   if(o.canEdit){
      if (EKey.Up == e.keyCode) {
         e.source.hUpIcon.src = o.styleIconPath('up');
         o.changeValue(e, 'Y');
      }else if (EKey.Down == e.keyCode){
         e.source.hDownIcon.src = o.styleIconPath('down');
         o.changeValue(e, 'N');
      }
   }
}
function FUiDataNumber_onEditKeyUp(e) {
   var o = this;
   if(o.canEdit){
      if (EKey.Up == e.keyCode){
         e.source.hUpIcon.src = o.styleIconPath('upSelect');
      }else if (EKey.Down == e.keyCode){
         e.source.hDownIcon.src = o.styleIconPath('downSelect');
      }
   }
}
function FUiDataNumber_onEditDoubleClick(){
   var o = this;
   this.onListClick();
}
function FUiDataNumber_validPattern(s) {
   var o = this;
   var flag = true;
   var s = RString.nvl(s);
   if(!RRegExp.test(ERegExp.NUMBER,s)){
      return false;
   }
   var r = null;
   if (o.dataType) {
      for (n in ERegExp) {
         if (RString.equals(n, o.dataType)) {
            r = ERegExp[n];
            break;
         }
      }
      if (RString.equals(RClass.name(r), "RegExp")) {
         flag = RRegExp.test(r, s) ? flag & true : flag & false;
      }
   }
   if (o.editMaxvalue) {
      flag = parseFloat(s) <= parseFloat(o.editMaxvalue) ? flag & true : flag & false;
   }
   if (o.editMinvalue) {
      flag = parseFloat(s) >= parseFloat(o.editMinvalue) ? flag & true : flag & false;
   }
   return flag;
}
function FUiDataNumber_refreshStyle(){
   var o = this;
   o.base.FEditControl.refreshStyle.call(o);
   o.hUpIcon.src = o.styleIconPath(o._hover ? 'UpSelect' : 'Up');
   o.hDownIcon.src = o.styleIconPath(o._hover ? 'DownSelect' : 'Down');
}
function FUiDataNumber_splitValue(v){
   var o = this;
   var s = RString.nvl(v.toString());
   var j = RString.findChars(s,"-");
   var b = RString.findChars(s,"%");
   s = RString.removeChars(s, "'");
   s = RString.removeChars(s, " ");
   s = RString.removeChars(s, "%");
   s = RString.removeChars(s, "-");
   if (!RString.isEmpty(s)) {
      var sc = '';
      var c = '';
      var n = 0;
      for(var i = s.length; i > -1; i--){
         if(i != 0 && n != 0 && n % 3 == 0){
            sc = "'" + s.charAt(i) + sc;
         }else{
            sc = s.charAt(i) + sc;
         }
         n++;
      }
      if(-1 != j){
          sc = "-" + sc ;
       }
      if(-1 != b){
         sc = sc +"%";
      }
      return sc;
   }
   return s;
}
function FUiDataNumber_removeSplit(s){
   var o = this;
   var s = RString.nvl(s);
   s = RString.removeChars(s,"'");
   s = RString.removeChars(s,"%");
   return s;
}
function FUiDataNumber_precisionValue(v){
   var o = this;
   if(RString.isEmpty(v)){
      return v;
   }
   var l1,l2;
   var p = RString.nvl(o.editPrecision);
   v = RString.nvl(v);
   if(RString.contains(p,'.')){
      var sp = p.split('.')
      l2 = sp[1].length;
   }else{
     l1 = p.length;
   }
   if(RString.contains(v, '.')){
      var vs = v.split('.');
      if(l2){
         if(l2 > vs[1].length){
            vs[1] = RString.rpad(vs[1],l2 - vs[1].length,'0');
         }else if(l2 <= vs[1].length){
            vs[1] = vs[1].substring(0, l2);
         }
      }
      if(l1){
         if(l1 > vs[0].length){
            alert(l1);
         }else if(l1 < vs[0].length){
            vs[0] = vs[0].substring(0, vs[0].length - l1);
            vs[0] = RString.rpad(vs[0],l1,'0');
         }
         vs[1] = null;
      }
      if(vs[1]){
         v = vs[0] + '.' + RString.nvl(vs[1]);
      }else{
         v = vs[0];
      }
   }else{
      if(l1){
         if(l1 <= v.length){
            v = v.substring(0, v.length - l1 + 1);
            for(var n = 0; n < l1 - 1;n++){
               v = v.concat('0');
            }
         }
         else if(l1 > v.length){
            v = 0;
         }
      }
      if(l2){
         v = v + '.';
         for(var n = 0; n < l2;n++){
            v = v.concat('0');
         }
      }
   }
   return v;
}
function FUiDataNumber_dispose(){
   var o = this;
   o.base.FEditControl.dispose.call(o);
   o.hLabel = null;
   o.hUpIcon = null;
   o.hDownIcon = null;
   o.hChgIic = null;
}
function FUiDataColumn(o){
   o = RClass.inherits(this, o, FControl, MDataField);
   o._displayList       = true;
   o._styleLabel        = RClass.register(o, new AStyle('_styleLabel'));
   o._styleSearchPanel  = RClass.register(o, new AStyle('_styleSearchPanel'));
   o._styleSearchEdit   = RClass.register(o, new AStyle('_styleSearchEdit'));
   o._styleIconSortUp   = RClass.register(o, new AStyleIcon('_styleIconSortUp'));
   o._styleIconSortDown = RClass.register(o, new AStyleIcon('_styleIconSortDown'));
   o._cellClass         = FCell;
   o._hForm             = null;
   o._hFormLine         = null;
   o._hIconPanel        = null;
   o._hIcon             = null;
   o._hLabel            = null;
   o._hSortPanel        = null;
   o._hSortUp           = null;
   o._hSortDown         = null;
   o._hSearchEditPanel  = null;
   o._hSearchEdit       = null;
   o.onBuildLabel       = FUiDataColumn_onBuildLabel;
   o.onBuildSearchIcon  = RMethod.empty;
   o.onBuildSearchEdit  = FUiDataColumn_onBuildSearchEdit;
   o.onBuildSearchDrop  = RMethod.empty;
   o.onBuildSearchForm  = FUiDataColumn_onBuildSearchForm;
   o.onBuildSearch      = FUiDataColumn_onBuildSearch;
   o.onBuildTotal       = FUiDataColumn_onBuildTotal;
   o.onBuildPanel       = FUiDataColumn_onBuildPanel;
   o.onBuild            = FUiDataColumn_onBuild;
   o.onSearchEnter      = RClass.register(o, new AEventMouseEnter('onSearchEnter'));
   o.onSearchClick      = RClass.register(o, new AEventClick('onSearchClick'));
   o.onSearchLeave      = RClass.register(o, new AEventMouseLeave('onSearchLeave'));
   o.onSearchKeyDown    = RClass.register(o, new AEventKeyDown('onSearchKeyDown'));
   o.createCell         = FUiDataColumn_createCell;
   return o;
}
function FUiDataColumn_onBuildLabel(p){
   var o = this;
   var hr = o._hFormLine;
   if (o._icon) {
      var hip = o._hIconPanel = RBuilder.appendTableCell(hr);
      o._hIcon = RBuilder.appendIcon(hip, o.icon);
   }
   var hl = o._hLabel = RBuilder.appendTableCell(hr);
   hl.innerHTML = RString.nvl(o.label());
   var hsp = o._hSortPanel = RBuilder.appendTableCell(hr);
   var hsu = o._hSortUp = RBuilder.appendIcon(hsp, o.styleIcon('SortUp', FUiDataColumn));
   hsu.style.display = 'none';
   var hsu = o._hSortDown = RBuilder.appendIcon(hsp, o.styleIcon('SortDown', FUiDataColumn));
   hsu.style.display = 'none';
}
function FUiDataColumn_onBuildSearchEdit(p){
   var o = this;
   var hc = o._hSearchEditPanel = RBuilder.appendTableCell(o._hSearchFormLine, o.styleName('SearchPanel'));
   var he = o._hSearchEdit = RBuilder.appendEdit(hc, o.styleName('SearchEdit'));
}
function FUiDataColumn_onBuildSearchForm(p){
   var o = this;
   var hf = o._hSearchForm = RBuilder.appendTable(o._hSearchPanel);
   hf.width = '100%';
   hf.style.backgroundColor = '#FFFFFF';
   var hfl = o._hSearchFormLine = hf.insertRow();
   if(RClass.isClass(o, FUiDataColumnButton)){
      o._hSearchPanel.style.backgroundColor = '#EEEFF1';
      o._hSearchPanel.style.borderLeft='1 solid #808080';
      o._hSearchPanel.style.borderTop='1 solid #808080';
      o._hSearchPanel.style.borderBottom = '1 solid #9EC4EB';
      return;
   }
   o.onBuildSearchIcon();
   o.onBuildSearchEdit();
   o.onBuildSearchDrop();
}
function FUiDataColumn_onBuildSearch(p){
   var o = this;
   var h = o._hSearchPanel = RBuilder.create(p, 'TD', o.styleName('SearchPanel'));
   h.style.backgroundColor = "#FFFFFF";
   h.style.borderBottom = '1 solid #9EC4EB';
   RHtml.linkSet(h, 'control', o);
  o.attachEvent('onSearchEnter', h);
  o.attachEvent('onSearchLeave', h);
  o.onBuildSearchForm(p);
}
function FUiDataColumn_onBuildTotal(p){
   var o = this;
   var h = o._hTotalPanel = RBuilder.create(p, 'TD');
   RHtml.linkSet(h, 'control', o);
   h.align = 'right';
   h.style.color = '#686860';
   h.style.backgroundColor = '#F8F8F0';
   h.style.borderBottom = '1 solid #B8B8B0';
   h.innerText = ' ';
}
function FUiDataColumn_onBuildPanel(p) {
   var o = this;
   o._hPanel = RBuilder.create(p, 'TD', o.styleName('Label'));
}
function FUiDataColumn_onBuild(p) {
   var o = this;
   var t = o.table;
   o._absEdit = o._editInsert || o._editUpdate || o._editDelete;
   if(!o._absEdit){
      if(!RString.isEmpty(o._lovReference)){
         o._hasDropArea = true;
      }else{
         o._hasDropArea = false;
      }
   }
   if (!RString.isEmpty(o._viewIcons)) {
      var im = o.iconMap = new TAttributes();
      im.split(o._viewIcons.replace(/\n/g, ';'), '=', ';');
      o.hasIconArea = im.count > 0;
   }
   o.__base.FControl.onBuild.call(o, p);
   var hp = o._hPanel;
   hp.style.padding = 4;
   var hf = o._hForm = RBuilder.appendTable(hp);
   if (!o._orderAble) {
     hf.style.cursor = 'hand';
   }
   var hr = o._hFormLine = RBuilder.appendTableRow(o._hForm);
   o.onBuildLabel(p);
   o.onBuildSearch(p);
   o.onBuildTotal(p);
   var h = o._hFixPanel = RBuilder.create(p, 'TD');
   h.height = 1;
   h.bgColor = '#FFFFFF'
   if(o._size.width < 40){
      o._size.width = 40;
   }
   RHtml.setSize(h, o._size);
   o._hPanel.style.pixelWidth = o.width;
   o._hFixPanel.style.pixelWidth = o.width;
}
function FUiDataColumn_createCell(p) {
   var o = this;
   var c = RClass.create(o._cellClass);
   var t = c._table = o._table;
   c._name = o._name;
   c._column = o;
   c.build(t._hPanel);
   c.setVisible(o._displayList);
   return c;
}
function FUiDataColumn_onCellMouseEnter(s, e){
   this.table.hoverRow(s.row, true);
}
function FUiDataColumn_onCellMouseLeave(s, e){
   this.table.hoverRow(s.row, false);
}
function FUiDataColumn_onCellMouseDown(s, e){
   var o = this;
   var t = s.table;
   var r = s.row;
   t.__focusCell = s;
   t.selectRow(r, !e.ctrlKey, true);
   var fc = RConsole.find(FFocusConsole);
   var c = fc.focusControl;
   if(RClass.isClass(c, FDropEditor)){
      if(c.source == s){
         return;
      }
   }
   RConsole.find(FFocusConsole).focus(s);
}
function FUiDataColumn_onCellClick(s, e){
   this.table.clickRow(s.row);
}
function FUiDataColumn_onCellDoubleClick(s, e){
   var o = this;
   var r = s.row;
   if(!o.isEditAble(r)){
      o.table.doubleClickRow(r);
   }
}
function FUiDataColumn_onCellKeyDown(s, e, he){
   var o = this;
   if(he){
      o.table.onCellKeyDown(s, e, he);
   }
}
function FUiDataColumn_oeMode(e){
   var o = this;
   if(e.isAfter()){
      var d = false;
      if(EAction.Design == e.mode){
         d = o.dispDesign;
      }else{
         d = o._displayList;
      }
      o.inModeDisplay = d;
      o.setVisible(d);
   }
   return EEventStatus.Continue;
}
function FUiDataColumn_oeRefresh(e) {
   var o = this;
   if(e.isBefore()){
      o.setVisible(o._displayList);
   }
}
function FUiDataColumn_onDataKeyDown(s, e) {
   var o = this;
   o.__base.MEditDescriptor.onDataKeyDown.call(o, s, e);
}
function FUiDataColumn_onDataChanged(s, e) {
   var o = this;
   o.table.setDataStatus(s.row, EDataStatus.Update);
}
function FUiDataColumn_onEditBegin(editor) {
   var o = this;
   var row = editor.row;
   o.editor = editor;
   o.table.editRow = row;
   o.table.editColumn = o;
   o.table.select(row, true);
   RLogger.debug(o, 'Edit begin (column={1} row={2} editor={3})', o.name, RClass.dump(row), RClass.dump(editor));
}
function FUiDataColumn_onEditEnd(e) {
   var o = this;
   var row = editor.row;
   var text = editor.text();
   o.setValue(row, o.formatValue(text));
   o.setText(row, text);
   o.table.setDataStatus(row, row.isChanged() ? EDataStatus.Update : EDataStatus.Unknown)
   o.editor = null;
   RLogger.debug(o, '{1}={2}\n{3}\n{4}', RClass.dump(editor), o.formatValue(text), o.dump(), row.dump());
}
function FUiDataColumn_onEditChanged(cell) {
   cell.row.refresh();
}
function FUiDataColumn_onHeadMouseDown(e) {
   var o = this;
   var tbl = o.table;
   var ct = tbl.dsViewer.count;
   var x = e.x;
   if(!RClass.isClass(o, FUiDataColumnButton)){
	   var l = o._hPanel.offsetWidth;
	   var r = l - 6;
	   if (x > 0 && x < r) {
	      if (ct > 0 && !RClass.isClass(e.source, FUiDataColumnStatus)) {
	         var cs = tbl.columns;
	         var len = cs.count;
	         for ( var n = 0; n < len; n++) {
	            var c = cs.value(n);
	            c._hSortUp.style.display = 'none';
	            c._hSortDown.style.display = 'none';
	         }
	         tbl.dsOrders.clear();
	         var oi = new TOrderItem();
	         var n = o.dataName;
	         if (o.sortType) {
	            oi.set(n, EOrder.Desc);
	            o._hSortUp.style.display = 'none';
	            o._hSortDown.style.display = 'block';
	         } else {
	            o._hSortUp.style.display = 'block';
	            o._hSortDown.style.display = 'none';
	            oi.set(n, EOrder.Asc);
	         }
	         o.sortType = !o.sortType;
	         tbl.dsOrders.push(oi);
	         tbl.dsSearch();
	      }
   }
   }
}
function FUiDataColumn_onRowClick(s, e){
   RConsole.find(FListenerConsole).process(FGridControl, EGridAction.RowClick, s.row, s.row);
}
function FUiDataColumn_createMoveable(p) {
   var o = this;
   var r = o.cloneMove;
   if (!r) {
      r = RClass.create(o.constructor);
      r.buildMode = EColumnMode.Drag;
      r.assign(o, EAssign.Property);
      r.build();
      o.cloneMove = r;
   }
   var hc = o.panel(EPanel.Move);
   var hr = r.panel(EPanel.Move);
   RHtml.setPixelRect(hr, RHtml.rect(hc));
   hr.className = r.styleName('DesignMove');
   hr.style.pixelLeft = hc.offsetLeft;
   r.show();
   return r;
}
function FUiDataColumn_searchValue() {
   var o = this;
   if(o._hSearchEdit){
      return o._hSearchEdit.value;
   }
}
function FUiDataColumn_setStyleStatus(row, status) {
   var o = this;
   var h = o.cell(row);
   if (h) {
      var s = h.style;
      switch (status) {
      case EStyle.Normal:
         if (row.isDelete()) {
            s.backgroundColor = EColor.Delete;
         } else {
            if (o.isEditAble(row)) {
               s.backgroundColor = EColor.Edit;
            } else {
               s.backgroundColor = EColor.Readonly;
            }
         }
         break;
      case EStyle.Select:
         if (row.isDelete()) {
            s.backgroundColor = EColor.Select;
         } else {
            s.textDecoration = 'none';
            if (o.isEditAble(row)) {
               s.backgroundColor = EColor.RowEditSelect;
            } else {
               s.backgroundColor = EColor.Select;
            }
         }
         break;
      case EStyle.Delete:
         s.textDecoration = 'line-through';
         s.backgroundColor = EColor.Select;
         break;
      }
   }
}
function FUiDataColumn_cell(r){
   return r.cell(this.index);
}
function FUiDataColumn_equalsValue(s, t) {
   return RString.nvl(s).replace(/\n/g, '\\n').replace(/\r/g, '\\r') == RString.nvl(t).replace(/\n/g, '\\n').replace(/\r/g, '\\r');
}
function FUiDataColumn_setWidth(w){
   var o = this;
   o._hPanel.style.pixelWidth = w;
   o._hFixPanel.style.pixelWidth = w;
}
function FUiDataColumn_setVisible(v){
   var o = this;
   o.isDisplay = v;
   var s = v ? 'block' : 'none';
   o._hPanel.style.display = s;
   o._hSearchPanel.style.display = s;
   o._hTotalPanel.style.display = s;
   o._hFixPanel.style.display = s;
}
function FUiDataColumn_moveCellFocus(row, p) {
   var o = this;
   var t = o.table;
   var mt = null;
   var mr = null;
   var mc = null;
   if(EPosition.Top == p){
      mt = o;
      mr = t.rows.get(t.rows.indexOf(row) - 1);
      if(mr){
         mc = mr.cell(mt.index);
      }
   }else if(EPosition.Bottom == p){
      mt = o;
      mr = t.rows.get(t.rows.indexOf(row) + 1);
      if(mr){
         mc = mr.cell(mt.index);
      }
   }else if (EPosition.Before == p){
      var fi = o.index - 1;
      var ri = t.rows.indexOf(row);
      for(var n = ri; n >= 0; n--){
         var fr = t.rows.get(n);
         for( var i = fi; i >= 0; i--){
            var ft = t.columns.value(i);
            if(RClass.isClass(ft, FUiDataColumn) && ft._displayList){
               mt = ft;
               mr = fr;
               mc = mr.cell(mt.index);
               break;
            }
         }
         if(mt){
            break;
         }
         fi = t.columns.count - 1;
      }
   }else if(EPosition.After == p){
      var fi = o.index + 1;
      var ri = t.rows.indexOf(row);
      var cc = t.columns.count;
      var rc = t.rows.count;
      for(var n = ri; n < rc; n++){
         var fr = t.rows.get(n);
         for(var i = fi; i < cc; i++){
            var ft = t.columns.value(i);
            if(RClass.isClass(ft, FUiDataColumn) && ft._displayList){
               mt = ft;
               mr = fr;
               mc = mr.cell(mt.index);
               break;
            }
         }
         if(mt){
            break;
         }
         fi = 0;
      }
   }
   if(mt && mr && mc){
      mc.focus(true);
      RConsole.find(FFocusConsole).focus(mc);
   }
}
function FUiDataColumn_getEditRange(){
   var o = this;
   var hc = o._hSearchPanel;
   var p = RHtml.offsetPosition(hc);
   var w = hc.offsetWidth;
   var h = hc.offsetHeight;
   return new TRange(p.x, p.y, w, h);
}
function FUiDataColumn_dispose(){
   var o = this;
   o.__base.FControl.dispose.call(o);
   RMemory.freeHtml(o._hSearchPanel);
   RMemory.freeHtml(o._hFixPanel);
   o._hForm = null;
   o._hFormLine = null;
   o._hIconPanel = null;
   o._hIcon = null;
   o._hHeadPanel = null;
   o._hLabel = null;
   o._hSortPanel = null;
   o._hSortUp = null;
   o._hSortDown = null;
   o._hSearchPanel = null;
   o._hSearchForm = null;
   o._hSearchFormLine = null;
   o._hSearchIconPanel = null;
   o._hSearchIcon = null;
   o._hSearchEditPanel = null;
   o._hSearchEdit = null;
   o._hSearchDropPanel = null;
   o._hSearchDrop = null;
   o._hFixPanel = null;
}
function FUiDataColumn_dump(s) {
   var o = this;
   s = RString.nvlStr(s);
   s.append(RClass.dump(o), '[');
   s.append('name=', o.name);
   s.appendIf(o.icon, ',icon=', o.icon);
   s.appendIf(o.label, ',label=', o.label);
   s.appendIf(o.align, ',align=', o.align);
   s.appendIf(o.valign, ',valign=', o.valign);
   s.appendIf(o.dataName, ',dataName=', o.dataName);
   s.appendIf(o.dataDefault, ',dataDefault=', o.dataDefault);
   s.appendIf(o.index, ',index=', o.index);
   s.append(']');
   s.append(' [editAccess=');
   s.append(o.editInsert ? 'I' : '_');
   s.append(o.editUpdate ? 'U' : '_');
   s.append(']');
   return s;
}
function FUiDataToolBar(o){
   o = RClass.inherits(this, o, FUiToolBar);
   return o;
}
function FUiDataToolButton(o){
   o = RClass.inherits(this, o, FUiControl, MListenerClick);
   o._icon            = RClass.register(o, new APtyString('_icon'));
   o._iconDisable     = RClass.register(o, new APtyString('_iconDisable'));
   o._hotkey          = RClass.register(o, new APtyString('_hotkey'));
   o._action          = RClass.register(o, new APtyString('_action'));
   o._styleNormal     = RClass.register(o, new AStyle('_styleNormal', 'Normal'));
   o._styleHover      = RClass.register(o, new AStyle('_styleHover', 'Hover'));
   o._stylePress      = RClass.register(o, new AStyle('_stylePress', 'Press'));
   o._styleDisable    = RClass.register(o, new AStyle('_styleDisable', 'Disable'));
   o._styleIconPanel  = RClass.register(o, new AStyle('_styleIcon', 'Icon'));
   o._styleIcon       = RClass.register(o, new AStyle('_styleIcon', 'Icon'));
   o._styleLabelPanel = RClass.register(o, new AStyle('_styleLabel', 'Label'));
   o._disabled        = false;
   o._hIconPanel      = null;
   o._hIcon           = null;
   o._hLabelPanel     = null;
   o.onBuildPanel     = FUiDataToolButton_onBuildPanel;
   o.onBuild          = FUiDataToolButton_onBuild;
   o.onEnter          = FUiDataToolButton_onEnter;
   o.onLeave          = FUiDataToolButton_onLeave;
   o.onMouseDown      = RClass.register(o, new AEventMouseDown('onMouseDown'), FUiDataToolButton_onMouseDown);
   o.onMouseUp        = RClass.register(o, new AEventMouseDown('onMouseUp'), FUiDataToolButton_onMouseUp);
   o.icon             = FUiDataToolButton_icon;
   o.setIcon          = FUiDataToolButton_setIcon;
   o.setLabel         = FUiDataToolButton_setLabel;
   o.setEnable        = FUiDataToolButton_setEnable;
   o.click            = FUiDataToolButton_click;
   o.dispose          = FUiDataToolButton_dispose;
   return o;
}
function FUiDataToolButton_onBuildPanel(p){
   var o = this;
   o._hPanel = RBuilder.createDiv(p, o.styleName('Normal'));
}
function FUiDataToolButton_onBuild(p){
   var o = this;
   o.__base.FUiControl.onBuild.call(o, p);
   var h = o._hPanel;
   o.attachEvent('onMouseDown', h);
   o.attachEvent('onMouseUp', h);
   var hf = o._hForm = RBuilder.appendTable(p);
   var hl = o._hLine = RBuilder.appendTableRow(hf);
   if(o._icon){
      var hl = o._hIconPanel = RBuilder.appendTableCell(hl);
      o._hIcon = RBuilder.appendIcon(hl, o.styleName('Icon'), o._icon);
   }
   if(o._label){
      var hl = o._hLabelPanel = RBuilder.appendTableCell(hl);
      o.setLabel(o._label);
   }
}
function FUiDataToolButton_onEnter(e){
   var o = this;
   if(!o._disabled){
      o._hPanel.className = o.styleName('Hover');
   }
}
function FUiDataToolButton_onLeave(e){
   var o = this;
   if(!o._disabled){
      o._hPanel.className = o.styleName('Normal');
   }
}
function FUiDataToolButton_onMouseDown(){
   var o = this;
   if(!o._disabled){
      o._hPanel.className = this.styleName('Press');
      o.click();
   }
}
function FUiDataToolButton_onMouseUp(h){
   var o = this;
   if(!o._disabled){
      o._hPanel.className = o.styleName('Hover');
   }
}
function FUiDataToolButton_icon(){
   return this._icon;
}
function FUiDataToolButton_setIcon(p){
   this._icon = p;
}
function FUiDataToolButton_setLabel(p){
   var o = this;
   var s = RString.nvl(p);
   o._label = s;
   if(o._hIcon){
      s = ' ' + o._label;
   }
   if(o._hLabel){
      o._hLabel.innerText = s;
   }
}
function FUiDataToolButton_setEnable(p){
   var o = this;
   o.__base.FUiControl.oeEnable.call(o, e);
   o._disabled = !e.enable;
   if(e.enable && o._icon){
      var is = RRes._iconPath(o._icon);
      if(o._hIcon.src != is){
         o._hIcon.src = is;
      }
   }else if(!e.enable && o._iconDisable){
      var is = RRes._iconPath(o._iconDisable);
      if(o._hIcon.src != is){
         o._hIcon.src = is;
      }
   }
   var css = o.styleName(e.enable ? 'Icon' : 'IconDisable');
   if(o._hIcon.className != css){
      o._hIcon.className = css;
   }
   var css = o.styleName(e.enable ? 'Button' : 'Disable');
   if(o._hPanel.className != css){
      o._hPanel.className = css;
   }
   var ci = o.styleIconPath(e.enable ? 'Button' : 'ButtonDisable');
   if(o._hButton.background != ci){
      o._hButton.background = ci;
   }
   return EEventStatus.Stop;
}
function FUiDataToolButton_click(){
   var o = this;
   RLogger.debug(o, 'Mouse button click. (label={1})' + o._label);
      o.processClickListener(o);
}
function FUiDataToolButton_dispose(){
   var o = this;
   o._hButton = null;
   o._hButtonLine = null;
   o._hButtonPanel = null;
   o._hIcon = null;
   o._hText = null;
   o.__base.FUiControl.dispose.call(o);
}
function FUiDataToolButton_onShowHint(a){
   var o = this;
   a.status = EActive.Finish;
   if(o.hintBox){
      o.hintBox.show();
   }
}
function FUiDataTreeView(o){
   o = RClass.inherits(this, o, FUiTreeView);
   o._serviceName     = RClass.register(o, new APtyString('_serviceName', 'service'));
   o._statusLoading   = false;
   o.lsnsLoaded       = new TListeners();
   o.lsnsNodeLoad     = new TListeners();
   o.lsnsNodeLoaded   = new TListeners();
   o.onLoaded         = FUiDataTreeView_onLoaded;
   o.onNodeLoaded     = FUiDataTreeView_onNodeLoaded;
   o.construct        = FUiDataTreeView_construct;
   o.buildNode        = FUiDataTreeView_buildNode;
   o.loadNode         = FUiDataTreeView_loadNode;
   o.loadUrl          = FUiDataTreeView_loadUrl;
   o.loadNodeUrl      = FUiDataTreeView_loadNodeUrl;
   o.loadService      = FUiDataTreeView_loadService;
   o.loadNodeService  = FUiDataTreeView_loadNodeService;
   o.load             = FUiDataTreeView_load;
   o.reloadNode       = FUiDataTreeView_reloadNode;
   o.reload           = FUiDataTreeView_reload;
   o.dispose          = FUiDataTreeView_dispose;
   o._queryService    = RClass.register(o, new APtyString('_queryService'));
   o.onQueryLoaded    = FUiDataTreeView_onQueryLoaded;
   o.doQuery          = FUiDataTreeView_doQuery;
   o.removeNode       = FUiDataTreeView_removeNode;
   o.clearNodes       = FUiDataTreeView_clearNodes;
   o.getChangedChecks = FUiDataTreeView_getChangedChecks;
   o.fetchExtendsAll  = FUiDataTreeView_fetchExtendsAll;
   o.tempAppendNodes  = FUiDataTreeView_tempAppendNodes;
   o.removeNodes      = FUiDataTreeView_removeNodes;
   o.tempAppendChild  = FUiDataTreeView_tempAppendChild;
   return o;
}
function FUiDataTreeView_onLoaded(p){
   var o = this;
   var x = p.root;
   if(x == null){
      throw new TError(o, 'Load tree data failure.');
   }
   var xt = x.find('TreeView');
   RControl.build(o, xt, null, o._hPanel);
   o.lsnsLoaded.process(p);
   var s = xt.get('service');
   if(s){
      o.loadNodeService(s);
   }
}
function FUiDataTreeView_onNodeLoaded(p){
   var o = this;
   var x = p.root;
   if(x == null){
      throw new TError(o, 'Load tree data failure.');
   }
   var np = p.connection.parentNode;
   o._loadingNode.hide();
   o._statusLoading = false;
   o.buildNode(np, x);
   o.lsnsNodeLoaded.process(p);
}
function FUiDataTreeView_construct(){
   var o = this;
   o.__base.FUiTreeView.construct.call(o);
}
function FUiDataTreeView_buildNode(pn, px){
   var o = this;
   var xns = px._nodes;
   if(xns){
      var xnc = xns.count();
      for(var i = 0; i < xnc; i++){
         var xn = xns.get(i);
         if(xn.isName('TreeNode')){
            var n = o.createNode();
            n.loadConfig(xn);
            if(pn){
               pn.push(n);
            }else{
               o.push(n);
            }
            o.appendNode(n, pn);
            if(xn.hasNode()){
               o.buildNode(n, xn);
               n.extend(false);
            }
         }
      }
   }
}
function FUiDataTreeView_loadNode(pn, pf){
   var o = this;
   o._statusLoading = true;
   var nt = null;
   var fn = pn;
   var svc = o._serviceName;
   while(RClass.isClass(fn, FUiTreeNode)){
      nt = fn.type();
      if(nt && nt._service){
         svc = nt._service;
         break;
      }
      fn = fn._parent;
   }
   if(!svc){
      throw new TError(o, 'Unknown service name.');
   }
   var fn = pn;
   while(RClass.isClass(fn, FUiTreeNode)){
      nt = fn.type();
      if(nt && nt._action){
         break;
      }
      fn = fn._parent;
   }
   var act = RString.nvl(nt._action, svc.action);
   if(!act){
      throw new TError(o, 'Unknown service action.');
   }
   o.lsnsNodeLoad.process(o, pn);
   var xd = new TXmlDocument();
   var x = xd.root();
   x.set('action', act);
   x.set('type', nt._linker);
   x.create('Attributes', o._attributes);
   var fn = pn;
   while(RClass.isClass(fn, FUiTreeNode)){
      var xc = x.create('TreeNode');
      fn.propertySave(xc);
      fn = fn._parent;
   }
   pn._extended = true;
   if(pn._child && pn._hImage){
      pn._hImage.src = RResource.iconPath(o._iconMinus);
   }
   var ln = o._loadingNode;
   var nr = pn._hPanel.rowIndex;
   if(ln._hPanel.rowIndex > nr){
      nr++;
   }
   RHtml.tableMoveRow(o._hNodeForm, ln._hPanel.rowIndex, nr);
   ln.setLevel(pn.level() + 1);
   ln.show();
   var sv = RService.parse(RString.nvl(svc, o._service));
   if(!sv){
      throw new TError(o, 'Unknown service.');
   }
   var u = RService.makeUrl(sv.service, act);
   var c = RConsole.find(FXmlConsole).sendAsync(u, xd);
   c.parentNode = pn;
   c.addLoadListener(o, o.onNodeLoaded);
}
function FUiDataTreeView_loadUrl(p){
   var o = this;
   var xc = RConsole.find(FXmlConsole);
   var c = xc.sendAsync(p);
   c.addLoadListener(o, o.onLoaded);
}
function FUiDataTreeView_loadNodeUrl(p, n){
   var o = this;
   var xc = RConsole.find(FXmlConsole);
   var c = xc.sendAsync(p);
   c.parentNode = RObject.nvl(n, o._focusNode);
   c.addLoadListener(o, o.onNodeLoaded);
}
function FUiDataTreeView_loadService(service, attrs){
   var o = this;
   var svc = RService.parse(RString.nvl(service, this._service));
   if(!svc){
      return alert('Unknown service');
   }
   attrs = RObject.nvl(attrs, o._attributes);
   var xd = new TXmlDocument();
   var xr = xd.root();
   xr.set('action', svc.action);
   RConsole.find(FEnvironmentConsole).build(xr);
   if(!attrs.isEmpty()){
      if(RClass.isClass(attrs, TNode)){
         xr.push(attrs);
      }if(RClass.isClass(attrs, TAttributes)){
         xr.create('Tree').attrs = attrs;
         xr.create('Attributes').attrs = attrs;
      }else{
         xr.create('Tree').value = attrs;
         xr.create('Attributes').value = attrs;
      }
   }
   var ln = o._loadingNode;
   var xc = RConsole.find(FXmlConsole);
   var c = xc.sendAsync(svc.url, xd);
   c.addLoadListener(o, o.onNodeLoaded);
}
function FUiDataTreeView_loadNodeService(ps, pa){
   var o = this;
   var svc = RService.parse(RString.nvl(ps, o._service));
   if(!svc){
      throw new TError(o, 'Unknown service.');
   }
   var as = RObject.nvl(pa, o._attributes);
   var xd = new TXmlDocument();
   var xr = xd.root();
   xr.set('action', svc.action);
   if(!as.isEmpty()){
      if(RClass.isClass(as, TNode)){
         xr.push(attrs);
      }if(RClass.isClass(as, TAttributes)){
      }else{
      }
   }
   var ln = o._loadingNode;
   var xc = RConsole.find(FXmlConsole);
   var c = xc.sendAsync(svc.url, xr);
   c.parentNode = o._focusNode;
   c.addLoadListener(o, o.onNodeLoaded);
}
function FUiDataTreeView_load(p){
   var o = this;
   o.loadService(o._serviceName);
}
function FUiDataTreeView_reloadNode(n){
   var o = this;
   n = RObject.nvl(n, o._focusNode);
   if(!n){
      return o.reload();
   }
   n.removeChildren();
   o.loadNode(n);
}
function FUiDataTreeView_reload(){
   var o = this;
   o.clear();
   o.loadUrl();
}
function FUiDataTreeView_dispose(){
   var o = this;
   o.__base.FUiTreeView.dispose.call(o);
}
function FUiDataTreeView_onQueryLoaded(e){
   var o = this;
   var doc = e.document;
   if(doc){
      var tvn = doc.root().find('TreeView');
      if(tvn && tvn._nodes){
         var nc = tvn._nodes.count;
         for(var n=0; n<nc; n++){
            var nd = tvn._nodes.get(n);
            if(nd.isName('TreeNode')){
               var nm = nd.get('name');
               var fd = o.findByName(nm);
               if(fd){
                  fd.loadQuery(nd);
               }
            }
         }
      }
   }
}
function FUiDataTreeView_doQuery(){
   var o = this;
   var svc = RService.parse(o._queryService);
   if(!svc){
      return alert('Unknown query service');
   }
   var doc = new TXmlDocument();
   var root = doc.root();
   root.set('action', svc.action);
   root.create('Attributes').attrs = o._attributes;
   var e = new TEvent(o, EXmlEvent.Send, o.onQueryLoaded);
   e.url = svc.url;
   e.document = doc;
   RConsole.find(FXmlConsole).process(e);
}
function FUiDataTreeView_removeNode(oNode){
   if(oNode){
      var nodes = new Array();
      var oLoopNode = null;
      var nCount = this._allNodes.length;
      for(var n=0; n<nCount; n++){
         oLoopNode = this._allNodes[n];
         if(oLoopNode != oNode){
            nodes[nodes.length] = oLoopNode;
         }
      }
      this._allNodes = nodes;
      var oParent = oNode.parent;
      if(oParent){
         nodes = new Array();
         nCount = oParent._nodes.length;
         for(var n=0; n<nCount; n++){
            oLoopNode = oParent._nodes[n];
            if(oLoopNode != oNode){
               nodes[nodes.length] = oLoopNode;
            }
         }
         oParent._nodes = nodes;
         oNode.parent.childrenHTML.removeChild(oNode.ownerHTML);
      }
      if(oParent._nodes.length == 0){
         oParent.imageHTML.src = this.imgEmpty;
      }
      return true;
   }
   return false;
}
function FUiDataTreeView_haveNodes(){
   return this.rootNode.hasChild();
}
function FUiDataTreeView_clearNodes(node){
   if(node){
      node.removeChildren();
   }
   return true;
   var nodes = new Array();
   var oLoopNode = null;
   var nCount = this._allNodes.length;
   for(var n=0; n<nCount; n++){
      oLoopNode = this._allNodes[n];
      if(oLoopNode.parent != oNode){
         nodes[nodes.length] = oLoopNode;
      }else{
      oNode.childrenHTML.removeChild(oLoopNode.ownerHTML);
      }
   }
   oNode.imageHTML.src = this.imgEmpty ;
   this._allNodes = nodes;
   return true;
}
function FUiDataTreeView_fetchExtendsAll(s){
   var o = this;
   if(s && RClass.isClass(s, FUiTreeNode)){
      fmMain.target = 'frmMain';
      fmMain.form_search.value = '';
      fmMain.form_order.value = '';
      fmMain.form_values.value = '';
      var type = node.type.typeName;
      if('table' == type || 'form' == type){
         fmMain.form_name.value = node.get('form');
         fmMain.action = top.RContext.context('/ent/apl/logic/form/InnerForm.wa?do=update');
         fmMain.submit();
      }else if('frameTree' == type){
         fmMain.action = top.RContext.context(node.get('redirect'));
         fmMain.submit();
      }
   }else{
   }
}
function FUiDataTreeView_getChangedChecks(){
   var o = this;
   var treeView = new TNode('TreeView');
   treeView.set('name', o.name);
   var rnd = RObject.nvl(o.rootNode, o);
   var cs = rnd.controls;
   for(var n = 0; n < cs.count; n++){
      var c = cs.value(n);
      c.pushChanged(treeView);
   }
   return treeView;
}
function FUiDataTreeView_tempAppendNodes(parent, config){
   parent = RObject.nvl(parent, this.workNode, this.rootNode);
   if(config && config._nodes){
      var count = config._nodes.count;
      if(count > 0){
         parent.child = true;
         parent.loaded = true;
         for(var n = 0; n < count; n++){
            var nc = config._nodes.get(n);
            if(nc && (nc.isName('Node') || nc.isName('TreeNode'))){
               var tn = RClass.create(FUiTreeNode);
               tn.parent = parent;
               tn._tree = this;
               tn.loadConfig(nc);
               if(nc._nodes){
                  tn.icon = 'ctl.FBrowser_Folder';
               }else{
                  tn.icon = 'ctl.FBrowser_Txt';
               }
               tn.build(0);
               tn.hide();
               if(nc._nodes){
                  this.tempAppendNodes(tn, nc);
               }
               parent.push(tn);
               this._allNodes.push(tn);
            }
         }
      }
   }
   this.rootNode.extend(true);
}
function FUiDataTreeView_removeNodes(node){
   node = RObject.nvl(node, this.workNode, this.rootNode);
   if(node.hasChild()){
      node.removeChildren();
   }
   node.remove();
}
function FUiDataTreeView_tempAppendChild(child){
   var o = this;
   var hc = o._hHeadLine.insertCell();
   hc.height = '100%';
   if(RClass.isClass(child, FTreeColumn)){
      hc.appendChild(child._hPanel);
   }
}
