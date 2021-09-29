// pages/order/order.js
var app =getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bar_index: 1,
    // price:0,
    Uid:"",
    address:{},
    // goods:{},
    hasOrder:false,
    currtab:0,
    tabs:[
      {
        id:0,
        name:"已预约",
        isActive:true
      },
      {
        id:1,
        name:"正在进行",
        isActive:false
      },
      {
        id:2,
        name:"已完成",
        isActive:false
      }
    ],
    OrderList:[],
    OrderList2:[],
    OrderList3:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  // tabChange: function (e) {
  //   this.setData({ currtab: e.detail.current })
  //   this.getOrder0List2
  // },
  onLoad: function (options) {
    var that =this
that.getOrder0List()
that.getOrder0List2()
that.getOrder0List3()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function (options) {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    const self=this;
   
    

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

  },
  handleItemTap(e){
    var self=this;
    //2 获取索引
      // console.log("e");
      // 5 触发父组件中的自定义事件 同事传递数据给 父组件
      const {index}=e.currentTarget.dataset;
      //3 获取data中的原数组
      let {tabs}=this.data;
      //4 循环数组
      // [].forEach 遍历数组 遍历数组的时候 修改了v，也会导致原数组被修改
      tabs.forEach((v,i)=>i===index?v.isActive=true:v.isActive=false)
      this.setData({
        tabs
      })
      if(index==0){
        
        wx.request({
         
          url: 'http://101.37.66.239:8080/cwq/wxgetAppByEmpId',
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
              hasOrder:true,
              // price:Allprice,
              OrderList:res.data.data
            })
          }
        })
      }
        
    
    if(index==1){
      wx.request({
         
        url: 'http://101.37.66.239:8080/cwq/wxgetAppByEmpId2',
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
            hasOrder:true,
            // price:Allprice,
            OrderList2:res.data.data
          })
        }
      })
    }
    
    if(index==2){
     
      wx.request({
         
        url: 'http://101.37.66.239:8080/cwq/wxgetAppByEmpId3',
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
            hasOrder:true,
            // price:Allprice,
            OrderList3:res.data.data
          })
        }
      })
     
    }

    },



getOrder0List2:function(){
  var self =this 
  wx.request({
         
    url: 'http://101.37.66.239:8080/cwq/wxgetAppByEmpId2',
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
        hasOrder:true,
        // price:Allprice,
        OrderList2:res.data.data
      })
    }
  })
},
getOrder0List3:function(){
  var self =this 
  wx.request({
         
    url: 'http://101.37.66.239:8080/cwq/wxgetAppByEmpId3',
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
        hasOrder:true,
        // price:Allprice,
        OrderList3:res.data.data
      })
    }
  })
}


})