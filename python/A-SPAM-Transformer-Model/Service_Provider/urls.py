from django.urls import path
from . import views

urlpatterns = [
    path('serviceproviderlogin/', views.serviceproviderlogin, name = "serviceproviderlogin"),
    path('View_Remote_Users/',views.View_Remote_Users,name="View_Remote_Users"),
    path('charts/<str:chart_type>/', views.charts, name="charts"),
    path('charts1/<str:chart_type>/', views.charts1, name="charts1"),
    path('likeschart/<str:like_chart>/', views.likeschart, name="likeschart"),
    path('View_SMSMessage_Type_Ratio/', views.View_SMSMessage_Type_Ratio, name="View_SMSMessage_Type_Ratio"),
    path('train_model/', views.train_model, name="train_model"),
    path('View_Prediction_Of_SMSMessage_Type/', views.View_Prediction_Of_SMSMessage_Type, name="View_Prediction_Of_SMSMessage_Type"),
    path('Download_Trained_DataSets/', views.Download_Trained_DataSets, name = "Download_Trained_DataSets"),
]