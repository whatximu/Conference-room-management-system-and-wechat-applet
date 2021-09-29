// pages/personInfo/personInfo.js
var app=getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
    userName:'',
    passWord:'',
    empId:'',
    empName:'',
    deptId:'',
    deptName:'',
    roleId:'',
    roleName:''
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that =this

       that.getroleName()
       that.getdeptName()
   var un=app.globalData.userName
   var pw =app.globalData.passWord
   var ei=app.globalData.empId
   var en=app.globalData.empName
   var en2=app.globalData.deptId
   var en3=app.globalData.roleId

   that.setData({
    userName:un,
    passWord:pw,
    empId:ei,
    empName:en,
    deptId:en2,
    roleId:en3
   

})

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
,

    getdeptName:function(){
 var that =this
        wx.request({
     
            url: 'http://localhost:8080/wxgetDept?id='+app.globalData.deptId,
             method: 'GET',
            //  data: {
            //    userName:userName,
            //    passWord:password
              
            //  },
             header: {
               "Content-Type": "application/x-www-form-urlencoded" // 默认值
            //    "content-type":"application/json"
             },
             success(res) {
               console.log('bumenL',res)
               that.setData({
                deptName:res.data.deptName
               })
               
                 
         
             }
           })
     
    
     
      
    },

    getroleName:function(){
        var that =this
        wx.request({
     
            url: 'http://localhost:8080/xxx/wxgetRole?id='+app.globalData.roleId,
             method: 'GET',

              
            //  },
             header: {
               "Content-Type": "application/x-www-form-urlencoded" // 默认值

             },
             success(res) {
               console.log('role',res)
     
               that.setData({
                roleName:res.data.roleName
               })
                 
         
             }
           })
     
    
    }
})