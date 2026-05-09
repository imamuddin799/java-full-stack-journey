import React, { useState, useMemo } from 'react';

const UseMemoExample = () => {
  const [number, setNumber] = useState(1);

  // Expensive factorial calculation
  const factorial = (n) => {
    console.log('Calculating factorial...');
    if (n <= 0) return 1;
    return n * factorial(n - 1);
  };

  // Memoize the factorial calculation to avoid unnecessary recalculations
  const memoizedFactorial = useMemo(() => factorial(number), [number]);

  return (
    <div>
      <h2>useMemo Example</h2>
      <label>
        Enter a number: 
        <input
          type="number"
          value={number}
          onChange={(e) => setNumber(parseInt(e.target.value) || 0)}
          min="0"
        />
      </label>
      <p>Factorial of {number} is: {memoizedFactorial}</p>
    </div>
  );
};

export default UseMemoExample;
