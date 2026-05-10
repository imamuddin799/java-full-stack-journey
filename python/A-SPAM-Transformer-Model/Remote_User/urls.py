from django.urls import path
from . import views

urlpatterns = [
    path('', views.login, name = 'login'),
    path('Register1/', views.Register1, name = 'Register1'),
    path('Predict_SMSMessage_Type/', views.Predict_SMSMessage_Type, name = 'Predict_SMSMessage_Type'),
    path('ViewYourProfile/', views.ViewYourProfile, name = 'ViewYourProfile'),
    path('Add_DataSet_Details/', views.Add_DataSet_Details, name = 'Add_DataSet_Details'),
]
