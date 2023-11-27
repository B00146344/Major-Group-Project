import React, { useState } from 'react';
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  StyleSheet,
  CheckBox,
} from 'react-native';

export default function Page() {
  const [email, setEmail] = useState('');
  const [pass, setPass] = useState('');
  const [pass2, setPass2] = useState('');
  const [rememberMe, setRememberMe] = useState(false);

  const runDBCallAsync = async () => {
    try {
      const url = `http://localhost:4000/app/Register?email=${email}&pass=${pass}&pass2=${pass2}`;
      const res = await fetch(url);
      const data = await res.json();

      if (data.data === 'valid') {
        console.log('Registration is valid!');
      } else {
        console.log('Not valid');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleSubmit = () => {
    console.log('Handling submit');

    // Add any validation logic here if needed

    // Call the database function
    runDBCallAsync();
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Sign up</Text>
      <TextInput
        style={styles.input}
        placeholder="Email Address"
        value={email}
        onChangeText={(text) => setEmail(text)}
        autoCapitalize="none"
        autoCompleteType="email"
        keyboardType="email-address"
      />
      <TextInput
        style={styles.input}
        placeholder="Password"
        value={pass}
        onChangeText={(text) => setPass(text)}
        secureTextEntry
      />
      <TextInput
        style={styles.input}
        placeholder="Re-enter Password"
        value={pass2}
        onChangeText={(text) => setPass2(text)}
        secureTextEntry
      />
      <View style={styles.checkboxContainer}>
        <CheckBox
          value={rememberMe}
          onValueChange={() => setRememberMe(!rememberMe)}
        />
        <Text style={styles.label}>Remember me</Text>
      </View>
      <TouchableOpacity
        style={styles.button}
        onPress={handleSubmit}
      >
        <Text style={styles.buttonText}>Register</Text>
      </TouchableOpacity>
      <View style={styles.linksContainer}>
        <Text style={styles.link}>Forgot password?</Text>
        <Text style={styles.link}>Don't have an account? Sign Up</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 16,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 16,
  },
  input: {
    height: 40,
    width: '100%',
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 16,
    paddingLeft: 8,
  },
  checkboxContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 16,
  },
  label: {
    marginLeft: 8,
  },
  button: {
    backgroundColor: '#2196F3',
    padding: 12,
    borderRadius: 8,
    alignItems: 'center',
  },
  buttonText: {
    color: 'white',
    fontWeight: 'bold',
  },
  linksContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 16,
  },
  link: {
    color: '#2196F3',
  },
});