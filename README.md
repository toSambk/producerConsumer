# producerConsumer

`producerConsumer` is a small Java project that demonstrates several implementations of the classic producer-consumer problem with a bounded shared buffer.

## What It Shows

Two kinds of worker threads share a limited buffer:

- a producer generates data items
- a consumer reads data items from the buffer

If the buffer is empty, the consumer must wait. If the buffer is full, the producer must wait until space becomes available.

## Project Structure

- `basicRealization` - a basic thread-based implementation
- `anotherRealization` - an alternative thread-based implementation
- `executorsRealization` - an implementation based on `ExecutorService`
- `concurrentSingleton` - several singleton examples for concurrent environments

## Build

Compile the project with Maven:

```bash
mvn clean package
```

## Run

Each package contains its own `Demo` entry point. For example, you can run one of them from your IDE or by executing the compiled classes after packaging.

The most illustrative starting points are:

- `basicRealization.Demo`
- `anotherRealization.Demo`
- `executorsRealization.Demo`

## Verification

The repository can be checked with:

```bash
mvn test
```

As of Monday, August 17, 2026, this command completes with `BUILD SUCCESS`, and Maven reports that there are no automated tests to run.
