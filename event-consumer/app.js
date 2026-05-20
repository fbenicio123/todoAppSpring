const express = require('express');
const { Kafka } = require('kafkajs');

const app = express();
const PORT = 3000;

// 1. Configuração do KafkaJS
const kafka = new Kafka({
  clientId: 'my-app',
  brokers: ['localhost:19092'], // Endereço do seu broker Kafka
  connectionTimeout: 10000,
  requestTimeout: 30000,
  retry: {
    initialRetryTime: 3000,
    retries: 10
  }
});

const consumer = kafka.consumer({ groupId: 'kafka-broker-1' });

// 2. Função para rodar o consumidor
const runConsumer = async () => {
  await consumer.connect();
  await consumer.subscribe({ topic: 'user-events', fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log({
        value: message.value.toString(),
        partition,
        topic
      });
      // Lógica de negócio aqui (ex: salvar no banco, atualizar cache)
    },
  });
};

// 3. Iniciar Express e Kafka
app.listen(PORT, () => {
  console.log(`Servidor Express rodando na porta ${PORT}`);
  runConsumer().catch(console.error);
});