import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, NativeModules } from 'react-native';

// Assuming BatteryReadout is correctly typed in your native module definitions
const { BatteryReadout } = NativeModules;

const BatteryStatusScreen: React.FC = () => {
  const [batteryLevel, setBatteryLevel] = useState<string>('Loading...');

  useEffect(() => {
    // Ensure your native module method is properly typed or use 'any' as a fallback
    BatteryReadout.getBatteryLevel()
      .then((level: number) => {
        setBatteryLevel(`Battery Level: ${level}%`);
      })
      .catch((error: any) => {
        console.error(error);
        setBatteryLevel('Failed to fetch battery level');
      });
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.text}>I DID IT MOTHERFUCKERS!</Text>  
      <Text style={styles.text}>{batteryLevel}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#006400', // Dark green background
  },
  text: {
    fontSize: 20,
    color: 'white', // White text
  },
});

export default BatteryStatusScreen;

