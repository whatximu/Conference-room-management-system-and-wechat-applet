// pages/person/person.js
var app =getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    PageCur: 'basics',
    bar_index: 2,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    thumb:'',
    orders:[],
    nickname:'',
    OrderList1:'',
    OrderList2:''
  
  },NavChange(e) {
    this.setData({
      PageCur: e.currentTarget.dataset.cur
    })
  },
  goinfo: function(){

    wx.navigateTo({
      url: '../personInfo/personInfo',
    })
  },
  onShow(){
        const userInfo = wx.getStorageSync("userInfo");
        this.setData({
          userInfo
        })
  },

  delnum:function(){
    var self =this 
    wx.request({
           
      url: 'http://localhost:8080/xxx/change_show_state',
      method:"POST",
      data:{
       empId:app.globalData.empId
      },
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        
        console.log(res.data.data)
        wx.hideTabBarRedDot({
          index: 2
          })

      }
    })
  },
  onLoad: function() {



    var that = this;
    that.getList()
    console.log('aaaaaa')
    that.getList2()
    that.delnum()
    // 查看是否授权
    wx.getSetting({
     success (res){
      if (res.authSetting['scope.userInfo']) {
       // 已经授权，可以直接调用 getUserInfo 获取头像昵称
       wx.getUserInfo({
        success: function(res) {
        lang:'zh_CN'
         console.log(res.userInfo)
         that.setData({
          result:'ok',// 结果
          nickName:res.userInfo.nickName,// 微信昵称
          avatarUrl:res.userInfo.avatarUrl,// 微信头像
         })
        }
       })
      }else{
       // 未授权，结果返回null
       that.setData({
        result:'null',// 结果
       })
      }
     }
    })
   },
   // 请求API授权，获得用户头像和昵称


   getList:function(){
    var self =this 
    wx.request({
           
      url: 'http://localhost:8080/xxx/wxgetnoticeshow1',
      method:"POST",
      data:{
       empId:app.globalData.empId
      },
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        
        console.log(res.data.data)
        self.setData({
          
          OrderList1:res.data.data
        })
      }
    })
  },
  getList2:function(){
    var self =this 
    wx.request({
           
      url: 'http://localhost:8080/xxx/wxgetnoticeshow2',
      method:"POST",
      data:{
       empId:app.globalData.empId
      },
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        
        console.log(res.data.data)
        self.setData({
          
          OrderList2:res.data.data
        })
      }
    })
  },
   bindGetUserInfo (e) {
     console.log(e.detail.userInfo)
    console.log(e.detail.userInfo.nickName)
    var that = this;
    that.setData({
     result:'ok',// 结果
     nickName:e.detail.userInfo.nickName,// 微信昵称
     avatarUrl:e.detail.userInfo.avatarUrl,// 微信头像
    })
   }
   
  
})