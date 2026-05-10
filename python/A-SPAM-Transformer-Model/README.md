# A SPAM Transformer Model

[![Python Version](https://img.shields.io/badge/python-3.13+-blue.svg)](https://www.python.org/)
[![Django Version](https://img.shields.io/badge/django-5.1.x-green.svg)](https://www.djangoproject.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

**GitHub repository:** https://github.com/imamuddin799/A-SPAM-Transformer-Model

## Overview

This project is a Django-based SMS spam classification platform with separate Remote User and Service Provider interfaces.
The application allows users to register, login, submit SMS messages for spam detection, and view prediction history.
Service providers can train machine learning models, compare classifier accuracies, view prediction ratios, and download predicted SMS records.

## Key Features

- User registration and login for remote users
- SMS spam/ham prediction using machine learning
- Ensemble prediction with SVM and KNeighbors classifiers
- Service provider dashboard for training and model comparison
- Accuracy and ratio charts for classifier performance
- Export predicted SMS records to Excel
- Uses a CSV dataset (`SMS_Datasets.csv`) for training and prediction
- Simple admin-style login for service provider access

## Technology Stack

- Python 3.13 (or compatible)
- Django 5.1.x
- MySQL for database storage
- pandas for CSV loading and preprocessing
- scikit-learn for model training and prediction
- xlwt for Excel export
- whitenoise for static file handling

## Project Structure

```
aspam_transformer_model/
├── .gitignore                     # Git ignore rules
├── aspam_transformer_model/       # Django project settings and WSGI
│   ├── __init__.py
│   ├── asgi.py
│   ├── settings.py               # Django settings, database config, static files
│   ├── urls.py                   # Root URL routing
│   └── wsgi.py
├── Database/                      # Database-related files or backups
├── DOCUMENT/                      # Documentation or additional project docs
├── Remote_User/                   # Remote user app
│   ├── __init__.py
│   ├── admin.py
│   ├── apps.py
│   ├── forms.py
│   ├── models.py                 # User registration and prediction models
│   ├── tests.py
│   ├── urls.py                   # Remote user routes
│   ├── views.py                  # Prediction and user profile logic
│   └── migrations/
├── Service_Provider/              # Service provider app
│   ├── __init__.py
│   ├── admin.py
│   ├── apps.py
│   ├── models.py
│   ├── tests.py
│   ├── urls.py                   # Service provider routes
│   ├── views.py                  # Training, analytics, and download logic
│   └── migrations/
├── Template/                      # HTML templates
│   ├── htmls/
│   │   ├── RUser/                # Remote user templates
│   │   └── SProvider/            # Service provider templates
│   ├── images/
│   └── media/
├── static/                        # Static assets
├── manage.py                      # Django management entrypoint
├── SMS_Datasets.csv               # Training dataset for SMS spam detection
├── labeled_data.csv               # Generated training export file (ignored by .gitignore)
└── README.md                      # This README
```

## Database Models

The app stores data in these models defined in `Remote_User/models.py`:

- `ClientRegister_Model`
  - username, email, password, phone number, country, state, city
- `aspam_transformer_prediction`
  - SMS_Message, Prediction
- `detection_accuracy`
  - classifier name and accuracy ratio
- `detection_ratio`
  - label name and prediction ratio

## URL Endpoints

### Remote User Routes

- `/` — Remote user login page
- `/Register1/` — User registration page
- `/Predict_SMSMessage_Type/` — SMS prediction form
- `/ViewYourProfile/` — Logged-in user profile page
- `/Add_DataSet_Details/` — Data upload placeholder page

### Service Provider Routes

- `/service/serviceproviderlogin/` — Service provider login
- `/service/View_Remote_Users/` — List registered users
- `/service/View_SMSMessage_Type_Ratio/` — Spam/Ham ratio view
- `/service/train_model/` — Train classifiers and view accuracy scores
- `/service/View_Prediction_Of_SMSMessage_Type/` — List predicted SMS messages
- `/service/Download_Trained_DataSets/` — Download predicted results as Excel
- `/service/charts/<type>/` — Analytics chart view
- `/service/charts1/<type>/` — Additional chart view
- `/service/likeschart/<type>/` — Like-chart analytics

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/imamuddin799/A-SPAM-Transformer-Model.git
   cd aspam_transformer_model
   ```

2. **Create and Activate a Virtual Environment** (recommended):

   ```bash
   python -m venv venv
   # On Windows:
   venv\Scripts\activate
   # On macOS/Linux:
   source venv/bin/activate
   ```

3. **Install Required Packages**:

   ```bash
   pip install django pandas scikit-learn xlwt whitenoise mysqlclient
   ```

   > If `mysqlclient` fails to install, use `PyMySQL` or your preferred MySQL driver.

4. **Configure the Database** in `aspam_transformer_model/settings.py`:

   ```python
   DATABASES = {
       'default': {
           'ENGINE': 'django.db.backends.mysql',
           'NAME': '<your_database_name>',
           'USER': '<your_mysql_username>',
           'PASSWORD': '<your_mysql_password>',
           'HOST': '127.0.0.1',
           'PORT': '3306',
       }
   }
   ```

5. **Run Migrations**:

   ```bash
   python manage.py makemigrations
   python manage.py migrate
   ```

6. **Start the Development Server**:

   ```bash
   python manage.py runserver
   ```

7. **Open the App in Your Browser**:

   ```
   http://127.0.0.1:8000/
   ```

## Notes

- The app depends on `SMS_Datasets.csv` being present in the project root.
- The service provider login is hard-coded as `<admin_username>` / `<admin_password>` (default: `Admin` / `Admin`).
- Passwords are stored in plain text in the current model and should be secured for production use.
- Static files are served via `whitenoise.middleware.WhiteNoiseMiddleware`.

## How Prediction Works

- Remote users enter an SMS message into the prediction form.
- The app cleans text data, vectorizes messages with `CountVectorizer`, and trains models on `SMS_Datasets.csv`.
- A voting classifier combines SVM and KNeighborsClassifier to predict `Spam` or `Ham`.
- Predictions are saved to the database and displayed to users.

## Training and Analytics

- The service provider can train multiple classifiers from `SMS_Datasets.csv`:
  - Naive Bayes
  - SVM
  - Logistic Regression
  - Decision Tree
  - Random Forest
  - SGD Classifier
  - KNeighborsClassifier
- Accuracy results are stored in `detection_accuracy`.
- Prediction ratios are stored in `detection_ratio`.
- The app can export prediction history as an Excel file.

## Suggested Improvements

- Add Django authentication instead of manual login.
- Use hashed passwords and secure user sessions.
- Add file upload support for dataset import.
- Add model persistence to avoid retraining on every request.
- Add unit tests for views and model logic.

## What Not to Upload to GitHub

When uploading this project to GitHub, ensure you do not commit sensitive or unnecessary files. The `.gitignore` file is provided to help with this, but here are key things to avoid uploading:

- **Virtual Environments**: Folders like `venv/`, `env/`, or `.venv/` contain installed packages and should not be shared.
- **Database Files**: Avoid uploading database files (e.g., `*.sqlite3`) or backups that may contain sensitive user data.
- **Secret Keys and Credentials**: Never commit API keys, database passwords, or any configuration files with real credentials. Use placeholders as shown in the installation guide.
- **Static and Media Files**: Source static assets required by the app (such as images, CSS, or JS files under `static/`) should be committed. Only generated static output folders or uploaded media should be ignored.
- **Logs and Temporary Files**: Files like `*.log`, `tmp/`, or `temp/` often contain runtime information and should be ignored.
- **IDE and OS Files**: Configurations for editors (`.vscode/`, `.idea/`) or OS-specific files (`.DS_Store`, `Thumbs.db`) are personal and not needed in the repository.
- **Generated Data**: Files like `labeled_data.csv` that are generated during runtime or training should not be uploaded unless they are part of the public dataset.
- **Environment Variables**: Files like `.env` that store environment-specific settings should be kept local.

Always review your commits before pushing to ensure no sensitive information is included. Use tools like `git status` and `git diff` to check what will be uploaded.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

- Project: A SPAM Transformer Model
- Framework: Django
- Purpose: SMS spam detection and analytics platform

