package com.Online_Survey_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


 class Survey {
    private String title;
    private List<Question> questions;

	public String getTitle() {

		return null;
	}
}

class Question {
    private String text;
    private QuestionType type;

}

enum QuestionType {
    MULTIPLE_CHOICE,
    TEXT_INPUT,
    RATING_SCALE
}

class Response {
    private User respondent;
    private Map<Question, String> answers;

}

class User {
    private String username;
    private String password;
    private UserRole role;

}

enum UserRole {
    ADMIN,
    USER
}

// Step 4: Database Management

class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/surveydb";
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rahul@123";
    
    public static Connection getConnection() throws SQLException {
    	System.out.println("hello");

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
    }
}

// Step 5: Implement Survey Creation

class SurveyDAO {
    public void saveSurvey(Survey survey) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO surveys (title) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, survey.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Step 9: Implement User Authentication and Authorization

class AuthService {
    public boolean authenticate(String username, String password) {

    	return true; // Dummy implementation
    }

    public UserRole authorize(String username) {
        
        return UserRole.USER; // Dummy implementation
    }
}

// Step 11: Deployment

public class main {
    public static void main(String[] args) {

    }
}

