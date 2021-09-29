
const app = getApp();
Page({
  options: {
    addGlobalClass: true,
  },
  data: {
    swiperList: [{
      id: 0,
      type: 'image',
      url: '图片链接'
    }, {
      id: 1,
        type: 'image',
        url: '图片链接',
    }, {
      id: 2,
      type: 'image',
      url: '图片链接'
    }],
    avatarUrl: '',
    userInfo:{},
    userName:'',
    passWord:'',
    deptName:'',
    empId:'',
    empName:'',
    elements:[
      {
        title: '预定',
        name: 'order',
        icon: 'like',
        color: 'blue'
      },
      {
        title: '关于',
        name: 'about',
        icon: 'settings',
        color: 'cyan'
      }, {
        title: '记录',
        name: 'record',
        icon: 'like',
        color: 'pink'
      },
      {
        title: '会议室',
        name: 'Room',
        icon: 'vip',
        color: 'olive'
      }
      ,
      {
        title: '特殊申请',
        name: 'Submit',
        icon: 'vip',
        color: 'blue'
      }
      ,
      {
        title: '设备详情',
        name: 'Einfo',
        icon: 'vip',
        color: 'olive'
      }
    ]

  },
  cardSwiper(e) {
    this.setData({
      cardCur: e.detail.current
    })
  },
  getdeptName:function(){
    var that =this
           wx.request({
        
               url: 'http://localhost:8080/xxx/wxgetDept?id='+app.globalData.deptId,
                method: 'GET',
             
            
                header: {
                  "Content-Type": "application/x-www-form-urlencoded" // 默认值
                  
                },
             
                success(res) {
                  console.log('bumenL',res)
                  that.setData({
                   deptName:res.data.deptName
                  })
                  
            
                }
              })
        
       
        
         
       },
  onLoad: function(options) {
    var that =this
    that.getnum()
    var un=app.globalData.userName
    var pw =app.globalData.passWord
    var ei=app.globalData.empId
    var en=app.globalData.empName
    
    
    that.setData({
     userName:un,
     passWord:pw,
     empId:ei,
     empName:en
    })

    that.getdeptName()
  } , 
  
  getnum:function(){
    var self =this 
    wx.request({
           
      url: 'http://localhost:8080/xxx/wxgetnoticeshow_num',
      method:"POST",
      data:{
       empId:app.globalData.empId
      },
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        
        console.log(res.data.data)
        var a =res.data.data+'';
        if (a != 0){
          wx.setTabBarBadge({
            index: 2,
            text: a,
          })
        }
      

      }
    })
  },
})