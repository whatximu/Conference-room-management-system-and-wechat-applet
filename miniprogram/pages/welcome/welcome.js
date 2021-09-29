const app = getApp();
Page({
  data: {
    code: '',
    avatarUrl: '',
    userInfo: {},
    hide: true,
    isBackTo: true
  },
  





  onLoad: function (options) {
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: res => {
              this.setData({
                avatarUrl: res.userInfo.avatarUrl,
                userInfo: res.userInfo,
              })
            }
          })
        }
      }
    })
  },

  check:function(e) {
      
    var thisa=this
    var userName=e.detail.value.userName
    var password=e.detail.value.password



      


wx.request({
     
       url: 'http://localhost:8080/xxx/wxuserLogin',
        method: 'POST',
        data: {
          userName:userName,
          passWord:password
         
        },
        header: {

          "content-type":"application/json"
        },
        success(res) {

          app.globalData.userName=res.data.data[0].userName
          app.globalData.passWord=res.data.data[0].passWord
          app.globalData.empId=res.data.data[0].empId
          app.globalData.empName=res.data.data[0].empName
          app.globalData.deptId=res.data.data[0].deptId
          app.globalData.roleId=res.data.data[0].roleId

        var code =res.data.code
    if(code=='0'){

    

      wx.switchTab({
        url: '../index/index',
      })      


      
    }else{
      wx.showToast({
        title: '密码错误',
        icon: 'none',
        duration: 3000,
        mask: true
      })
      console.log("err")

    }

            
    
        }
      })

    








    },


  onShow: function () {

  }

})