"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[774],{2774:(e,a,n)=>{n.r(a),n.d(a,{default:()=>C});n(9524),n(721),n(6158),n(3134),n(3510),n(1808),n(7547),n(8971),n(3448),n(6696),n(73),n(1680),n(826),n(3299),n(6505),n(8218),n(8838),n(6507);var l=n(7377),u=n(8479),t=(n(1250),n(1290)),i=n(6754),o=n(4432),r=(n(1818),n(1284),n(5014),n(2443),{class:"formModel_btn_box"});const d={__name:"formModel",emits:["formModelChange"],setup:function(e,a){var n,u=a.expose,i=a.emit,o=null===(n=(0,l.FN)())||void 0===n?void 0:n.appContext.config.globalProperties,d="keyanrenyuan",s="科研人员",c=(0,t.iH)({}),v=(0,t.iH)({keyanzhanghao:!1,keyanmima:!1,keyanrenyuanxingming:!1,touxiang:!1,xingbie:!1,shoujihaoma:!1}),f=(0,t.iH)(!1),g=(0,t.iH)(!1),m=(0,t.iH)(""),p=function(e,a,n){a?null!==o&&void 0!==o&&o.$toolUtil.isMobile(a)?n():n(new Error("请输入正确的手机号码")):n()},h=(0,t.iH)({keyanzhanghao:[{required:!0,message:"请输入",trigger:"blur"}],keyanmima:[{required:!0,message:"请输入",trigger:"blur"}],keyanrenyuanxingming:[{required:!0,message:"请输入",trigger:"blur"}],touxiang:[],xingbie:[],shoujihaoma:[{validator:p,trigger:"blur"}]}),y=(0,t.iH)(null),k=(0,t.iH)(0),w=(0,t.iH)(""),b=function(e){c.value.touxiang=e},_=(0,t.iH)([]),x=function(){c.value={keyanzhanghao:"",keyanmima:"",keyanrenyuanxingming:"",touxiang:"",xingbie:"男",shoujihaoma:""}},W=function(){null===o||void 0===o||o.$http({url:"".concat(d,"/info/").concat(k.value),method:"get"}).then((function(e){new RegExp("../../../file","g");c.value=e.data.data,f.value=!0}))},z=(0,t.iH)(""),U=(0,t.iH)(""),C=(0,t.iH)(""),H=(0,t.iH)(""),j=(0,t.iH)(""),V=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:null,a=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"add",n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:"",l=arguments.length>3&&void 0!==arguments[3]?arguments[3]:null,u=arguments.length>4&&void 0!==arguments[4]?arguments[4]:null,t=arguments.length>5&&void 0!==arguments[5]?arguments[5]:null,i=arguments.length>6&&void 0!==arguments[6]?arguments[6]:null,r=arguments.length>7&&void 0!==arguments[7]?arguments[7]:null;if(x(),e&&(k.value=e,w.value=a),"add"==a)g.value=!0,m.value="新增"+s,f.value=!0;else if("info"==a)g.value=!1,m.value="查看"+s,W();else if("edit"==a)g.value=!0,m.value="修改"+s,W();else if("cross"==a){for(var d in g.value=!0,m.value=n,l)"keyanzhanghao"!=d?"keyanmima"!=d?"keyanrenyuanxingming"!=d?"touxiang"!=d?"xingbie"!=d?"shoujihaoma"!=d||(c.value.shoujihaoma=l[d],v.value.shoujihaoma=!0):(c.value.xingbie=l[d],v.value.xingbie=!0):(c.value.touxiang=l[d],v.value.touxiang=!0):(c.value.keyanrenyuanxingming=l[d],v.value.keyanrenyuanxingming=!0):(c.value.keyanmima=l[d],v.value.keyanmima=!0):(c.value.keyanzhanghao=l[d],v.value.keyanzhanghao=!0);l&&(z.value=l),u&&(U.value=u),i&&(C.value=i),t&&(H.value=t),r&&(j.value=r),c.value.xingbie="男",f.value=!0}null===o||void 0===o||o.$http({url:"".concat(null===o||void 0===o?void 0:o.$toolUtil.storageGet("sessionTable"),"/session"),method:"get"}).then((function(e){e.data.data})),_.value="男,女".split(",")};u({init:V});var $=function(){f.value=!1},M=function(){null!=c.value.touxiang&&(c.value.touxiang=c.value.touxiang.replace(new RegExp(null===o||void 0===o?void 0:o.$config.url,"g"),""));U.value;var e=JSON.parse(JSON.stringify(z.value)),a="",n="",l="";if("cross"==w.value&&""!=H.value)if(H.value.startsWith("["))a=null===o||void 0===o?void 0:o.$toolUtil.storageGet("userid"),n=e["id"],l=H.value.replace(/\[/,"").replace(/\]/,"");else{for(var u in e)u==H.value&&(e[u]=j.value);q(e)}y.value.validate((function(e){if(e)if(a&&n){c.value.crossuserid=a,c.value.crossrefid=n;var u={page:1,limit:1e3,crossuserid:c.value.crossuserid,crossrefid:c.value.crossrefid};null===o||void 0===o||o.$http({url:"".concat(d,"/page"),method:"get",params:u}).then((function(e){if(e.data.data.total>=l)return null===o||void 0===o||o.$toolUtil.message("".concat(C.value),"error"),!1;null===o||void 0===o||o.$http({url:"".concat(d,"/").concat(c.value.id?"update":"save"),method:"post",data:c.value}).then((function(e){null===o||void 0===o||o.$toolUtil.message("操作成功","success",(function(){f.value=!1,i("formModelChange")}))}))}))}else null===o||void 0===o||o.$http({url:"".concat(d,"/").concat(c.value.id?"update":"save"),method:"post",data:c.value}).then((function(e){null===o||void 0===o||o.$toolUtil.message("操作成功","success",(function(){f.value=!1,i("formModelChange")}))}))}))},q=function(e){null===o||void 0===o||o.$http({url:"".concat(U.value,"/update"),method:"post",data:e}).then((function(e){}))};return function(e,a){var n=(0,l.up)("el-input"),u=(0,l.up)("el-form-item"),t=(0,l.up)("el-col"),i=(0,l.up)("uploads"),o=(0,l.up)("el-option"),d=(0,l.up)("el-select"),s=(0,l.up)("el-row"),p=(0,l.up)("el-form"),k=(0,l.up)("el-button"),x=(0,l.up)("el-dialog");return(0,l.wg)(),(0,l.iD)("div",null,[(0,l.Wm)(x,{modelValue:f.value,"onUpdate:modelValue":a[5]||(a[5]=function(e){return f.value=e}),title:m.value,width:"80%","destroy-on-close":"",fullscreen:!1},(0,l.Nv)({default:(0,l.w5)((function(){return[(0,l.Wm)(p,{class:"formModel_form",ref_key:"formRef",ref:y,model:c.value,"label-width":"$template2.back.add.form.base.labelWidth",rules:h.value},{default:(0,l.w5)((function(){return[(0,l.Wm)(s,null,{default:(0,l.w5)((function(){return[(0,l.Wm)(t,{span:12},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"科研账号",prop:"keyanzhanghao"},{default:(0,l.w5)((function(){return[(0,l.Wm)(n,{class:"list_inp",modelValue:c.value.keyanzhanghao,"onUpdate:modelValue":a[0]||(a[0]=function(e){return c.value.keyanzhanghao=e}),placeholder:"科研账号",type:"text",readonly:!(g.value&&!v.value.keyanzhanghao)},null,8,["modelValue","readonly"])]})),_:1})]})),_:1}),(0,l.Wm)(t,{span:12},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"科研密码",prop:"keyanmima"},{default:(0,l.w5)((function(){return[(0,l.Wm)(n,{class:"list_inp",modelValue:c.value.keyanmima,"onUpdate:modelValue":a[1]||(a[1]=function(e){return c.value.keyanmima=e}),placeholder:"科研密码",type:"password",readonly:!(g.value&&!v.value.keyanmima)},null,8,["modelValue","readonly"])]})),_:1})]})),_:1}),(0,l.Wm)(t,{span:12},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"科研人员姓名",prop:"keyanrenyuanxingming"},{default:(0,l.w5)((function(){return[(0,l.Wm)(n,{class:"list_inp",modelValue:c.value.keyanrenyuanxingming,"onUpdate:modelValue":a[2]||(a[2]=function(e){return c.value.keyanrenyuanxingming=e}),placeholder:"科研人员姓名",type:"text",readonly:!(g.value&&!v.value.keyanrenyuanxingming)},null,8,["modelValue","readonly"])]})),_:1})]})),_:1}),(0,l.Wm)(t,{span:24},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"头像",prop:"touxiang"},{default:(0,l.w5)((function(){return[(0,l.Wm)(i,{disabled:!(g.value&&!v.value.touxiang),action:"file/upload",tip:"请上传头像",limit:3,style:{width:"100%","text-align":"left"},fileUrls:c.value.touxiang?c.value.touxiang:"",onChange:b},null,8,["disabled","fileUrls"])]})),_:1})]})),_:1}),(0,l.Wm)(t,{span:12},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"性别",prop:"xingbie"},{default:(0,l.w5)((function(){return[(0,l.Wm)(d,{class:"list_sel",disabled:!(g.value&&!v.value.xingbie),modelValue:c.value.xingbie,"onUpdate:modelValue":a[3]||(a[3]=function(e){return c.value.xingbie=e}),placeholder:"请选择性别"},{default:(0,l.w5)((function(){return[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(_.value,(function(e,a){return(0,l.wg)(),(0,l.j4)(o,{label:e,value:e},null,8,["label","value"])})),256))]})),_:1},8,["disabled","modelValue"])]})),_:1})]})),_:1}),(0,l.Wm)(t,{span:12},{default:(0,l.w5)((function(){return[(0,l.Wm)(u,{label:"手机号码",prop:"shoujihaoma"},{default:(0,l.w5)((function(){return[(0,l.Wm)(n,{class:"list_inp",modelValue:c.value.shoujihaoma,"onUpdate:modelValue":a[4]||(a[4]=function(e){return c.value.shoujihaoma=e}),placeholder:"手机号码",type:"text",readonly:!(g.value&&!v.value.shoujihaoma)},null,8,["modelValue","readonly"])]})),_:1})]})),_:1})]})),_:1})]})),_:1},8,["model","rules"])]})),_:2},[g.value||"logistics"==w.value||"reply"==w.value?{name:"footer",fn:(0,l.w5)((function(){return[(0,l._)("span",r,[(0,l.Wm)(k,{class:"formModel_cancel",onClick:$},{default:(0,l.w5)((function(){return[(0,l.Uk)("取消")]})),_:1}),(0,l.Wm)(k,{class:"formModel_confirm",type:"primary",onClick:M},{default:(0,l.w5)((function(){return[(0,l.Uk)(" 提交 ")]})),_:1})])]})),key:"0"}:void 0]),1032,["modelValue","title"])])}}};var s=n(7326);const c=(0,s.Z)(d,[["__scopeId","data-v-1318d4fa"]]),v=c;var f=function(e){return(0,l.dD)("data-v-5e1cc92a"),e=e(),(0,l.Cn)(),e},g={class:"app-contain"},m={class:"list_search_view"},p={class:"search_view"},h=f((function(){return(0,l._)("div",{class:"search_label"}," 科研账号： ",-1)})),y={class:"search_box"},k={class:"search_btn_view"},w=f((function(){return(0,l._)("br",null,null,-1)})),b={class:"btn_view"},_=f((function(){return(0,l._)("br",null,null,-1)})),x={key:0},W={key:1};const z={__name:"list",setup:function(e){var a,n=null===(a=(0,l.FN)())||void 0===a?void 0:a.appContext.config.globalProperties,r="keyanrenyuan",d="科研人员";(0,i.yj)();(0,l.bv)((function(){}));var s=(0,t.iH)(null),c=(0,t.iH)(null),f=(0,t.iH)({page:1,limit:20,sort:"id",order:"desc"}),z=(0,t.iH)({}),U=(0,t.iH)([]),C=(0,t.iH)(!1),H=function(e){(0,l.Y3)((function(){c.value.clearSelection(),c.value.toggleRowSelection(e)}))},j=function(){C.value=!0;var e=JSON.parse(JSON.stringify(f.value));e["sort"]="id",e["order"]="desc",z.value.keyanzhanghao&&""!=z.value.keyanzhanghao&&(e["keyanzhanghao"]="%"+z.value.keyanzhanghao+"%"),null===n||void 0===n||n.$http({url:"".concat(r,"/page"),method:"get",params:e}).then((function(e){C.value=!1,s.value=e.data.data.list,M.value=Number(e.data.data.total)}))},V=function(e){var a=(0,t.iH)([]);if(e)a.value=[e];else{if(!U.value.length)return!1;for(var l in U.value)a.value.push(U.value[l].id)}o.T.confirm("是否删除选中".concat(d),"提示",{confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then((function(){null===n||void 0===n||n.$http({url:"".concat(r,"/delete"),method:"post",data:a.value}).then((function(e){null===n||void 0===n||n.$toolUtil.message("删除成功","success",(function(){j()}))}))}))},$=function(e){U.value=e},M=(0,t.iH)(0),q=(0,t.iH)(["total","prev","pager","next","sizes"]),N=function(e){f.value.limit=e,j()},S=function(e){f.value.page=e,j()},D=function(){f.value.page=f.value.page-1,j()},R=function(){f.value.page=f.value.page+1,j()},J=function(e,a){return null===n||void 0===n?void 0:n.$toolUtil.isAuth(e,a)},O=function(){f.value.page=1,j()},T=(0,t.iH)(null),E=function(){O()},F=function(){T.value.init()},P=function(){U.value.length&&T.value.init(U.value[0].id,"edit")},A=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:null;e?T.value.init(e,"info"):U.value.length&&T.value.init(U.value[0].id,"info")},B=function(){j()};return B(),function(e,a){var n=(0,l.up)("el-input"),t=(0,l.up)("el-button"),i=(0,l.up)("el-form"),o=(0,l.up)("el-table-column"),r=(0,l.up)("el-image"),d=(0,l.up)("el-table"),j=(0,l.up)("el-pagination"),B=(0,l.Q2)("loading");return(0,l.wg)(),(0,l.iD)("div",null,[(0,l._)("div",g,[(0,l._)("div",m,[(0,l.Wm)(i,{model:z.value,class:"search_form"},{default:(0,l.w5)((function(){return[(0,l._)("div",p,[h,(0,l._)("div",y,[(0,l.Wm)(n,{class:"search_inp",modelValue:z.value.keyanzhanghao,"onUpdate:modelValue":a[0]||(a[0]=function(e){return z.value.keyanzhanghao=e}),placeholder:"科研账号",clearable:""},null,8,["modelValue"])])]),(0,l._)("div",k,[(0,l.Wm)(t,{class:"search_btn",type:"primary",onClick:a[1]||(a[1]=function(e){return O()}),size:"small"},{default:(0,l.w5)((function(){return[(0,l.Uk)("搜索")]})),_:1})])]})),_:1},8,["model"]),w,(0,l._)("div",b,[J("keyanrenyuan","新增")?((0,l.wg)(),(0,l.j4)(t,{key:0,type:"success",onClick:F},{default:(0,l.w5)((function(){return[(0,l.Uk)("新增")]})),_:1})):(0,l.kq)("",!0),J("keyanrenyuan","查看")?((0,l.wg)(),(0,l.j4)(t,{key:1,type:"info",disabled:1!=U.value.length,onClick:a[2]||(a[2]=function(e){return A(null)})},{default:(0,l.w5)((function(){return[(0,l.Uk)("详情")]})),_:1},8,["disabled"])):(0,l.kq)("",!0),J("keyanrenyuan","修改")?((0,l.wg)(),(0,l.j4)(t,{key:2,type:"primary",disabled:1!=U.value.length,onClick:P},{default:(0,l.w5)((function(){return[(0,l.Uk)("修改")]})),_:1},8,["disabled"])):(0,l.kq)("",!0),J("keyanrenyuan","删除")?((0,l.wg)(),(0,l.j4)(t,{key:3,type:"danger",disabled:!U.value.length,onClick:a[3]||(a[3]=function(e){return V(null)})},{default:(0,l.w5)((function(){return[(0,l.Uk)("删除")]})),_:1},8,["disabled"])):(0,l.kq)("",!0)])]),_,J("keyanrenyuan","查看")?(0,l.wy)(((0,l.wg)(),(0,l.j4)(d,{key:0,border:"",stripe:!1,onSelectionChange:$,ref_key:"table",ref:c,data:s.value,onRowClick:H},{default:(0,l.w5)((function(){return[(0,l.Wm)(o,{resizable:!0,align:"left","header-align":"left",type:"selection",width:"55"}),(0,l.Wm)(o,{label:"序号",width:"70",resizable:!0,sortable:!0,align:"left","header-align":"left"},{default:(0,l.w5)((function(e){return[(0,l.Uk)((0,u.zw)(e.$index+1),1)]})),_:1}),(0,l.Wm)(o,{resizable:!0,sortable:!0,align:"left","header-align":"left",label:"科研账号"},{default:(0,l.w5)((function(e){return[(0,l.Uk)((0,u.zw)(e.row.keyanzhanghao),1)]})),_:1}),(0,l.Wm)(o,{resizable:!0,sortable:!0,align:"left","header-align":"left",label:"科研人员姓名"},{default:(0,l.w5)((function(e){return[(0,l.Uk)((0,u.zw)(e.row.keyanrenyuanxingming),1)]})),_:1}),(0,l.Wm)(o,{label:"头像",width:"120",resizable:!0,sortable:!0,align:"left","header-align":"left"},{default:(0,l.w5)((function(a){return[a.row.touxiang?((0,l.wg)(),(0,l.iD)("div",x,["http"==a.row.touxiang.substring(0,4)?((0,l.wg)(),(0,l.j4)(r,{key:0,"preview-teleported":"","preview-src-list":[a.row.touxiang.split(",")[0]],src:a.row.touxiang.split(",")[0],style:{width:"100px",height:"100px"}},null,8,["preview-src-list","src"])):((0,l.wg)(),(0,l.j4)(r,{key:1,"preview-teleported":"","preview-src-list":[e.$config.url+a.row.touxiang.split(",")[0]],src:e.$config.url+a.row.touxiang.split(",")[0],style:{width:"100px",height:"100px"}},null,8,["preview-src-list","src"]))])):((0,l.wg)(),(0,l.iD)("div",W,"无图片"))]})),_:1}),(0,l.Wm)(o,{resizable:!0,sortable:!0,align:"left","header-align":"left",label:"性别"},{default:(0,l.w5)((function(e){return[(0,l.Uk)((0,u.zw)(e.row.xingbie),1)]})),_:1}),(0,l.Wm)(o,{resizable:!0,sortable:!0,align:"left","header-align":"left",label:"手机号码"},{default:(0,l.w5)((function(e){return[(0,l.Uk)((0,u.zw)(e.row.shoujihaoma),1)]})),_:1}),(0,l.Wm)(o,{label:"操作",width:"300",resizable:!0,sortable:!0,align:"left","header-align":"left"},{default:(0,l.w5)((function(e){return[J("keyanrenyuan","查看")?((0,l.wg)(),(0,l.j4)(t,{key:0,type:"info",onClick:function(a){return A(e.row.id)}},{default:(0,l.w5)((function(){return[(0,l.Uk)("详情")]})),_:2},1032,["onClick"])):(0,l.kq)("",!0)]})),_:1})]})),_:1},8,["data"])),[[B,C.value]]):(0,l.kq)("",!0),(0,l.Wm)(j,{background:"",layout:q.value.join(","),total:M.value,"page-size":f.value.limit,"prev-text":"上一页","next-text":"下一页","hide-on-single-page":!1,style:{padding:"0",margin:"20px auto",whiteSpace:"nowrap",color:"#333",textAlign:"center",width:"100%",fontWeight:"500"},onSizeChange:N,onCurrentChange:S,onPrevClick:D,onNextClick:R},null,8,["layout","total","page-size"])]),(0,l.Wm)(v,{ref_key:"formRef",ref:T,onFormModelChange:E},null,512)])}}},U=(0,s.Z)(z,[["__scopeId","data-v-5e1cc92a"]]),C=U}}]);
//# sourceMappingURL=774.9c84ef04.js.map